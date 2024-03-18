/*
 * Copyright (C) 2024 GROUP ANDBANK - All Rights Reserved
 *
 * This source code is protected under international copyright law.  All rights
 * reserved and protected by the copyright holders.
 * This file is confidential and only available to authorized individuals with the
 * permission of the copyright holders.  If you encounter this file and do not have
 * permission, please contact the copyright holders and delete this file.
 */
package com.andbank.emir;

import static com.andbank.emir.EmirRefitColumns.ENTITY_RESPONSIBLE_FOR_REPORTING;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CSV to XML Utility.
 * 
 * @author luis.aguilar@devone.es
 * @version 1.0.1
 */
public class Csv2XmlUtil {

	private static Logger logger = LoggerFactory.getLogger(Csv2XmlUtil.class);

	// XSD
	private static final String ESMAUG_DATTAR_XSD = "/com/andbank/emir/xsd/auth.030.001.03_ESMAUG_DATTAR_1.1.0.xsd";

	/// File Name Format
	private static final String FILE_NAME_FORMAT = "%s.UP.C%s.S%s";
	private static final String FILE_EXTENSION = ".xml";

	// Velocity Templates
	private static final String DTCC_WRAPPER_VTL = "com/andbank/emir/templates/DTCC_Wrapper.vtl";
	private static final String DOCUMENT_VTL = "com/andbank/emir/templates/Document.vtl";

	private static final VelocityEngine velocityEngine = new VelocityEngine();

	private final SimpleDateFormat sdfYYYYMMDDTHHMMSSZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	private final Random ran = new Random();

	static {
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
		velocityEngine.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());
		try {
			velocityEngine.init();
		} catch (final Exception e) {
			logger.error("Error while initializing the Velocity runtime engine", e);
		}
	}

	/**
	 * Exports the {@code row} as an EMIR Refit XML.
	 *
	 * @param outputDir   the directory where the XML is written
	 * @param environment the environment (UAT or Production)
	 * @param ocode       the O-code (0RRO, 7RR0, 8RR0)
	 * @param sysId       the DataTrak SYSID
	 * @param csvReader   the CsvReader
	 * @return true if the export finished successfully
	 */
	public boolean exportAsXML(final String outputDir, final String environment, final String ocode, final String sysId,
			final CsvReader csvReader) {

		if (csvReader.getNumberOfRows() == 0) {
			logger.warn("CSV contains no rows");
			return true;
		}

		final List<Map<String, Object>> valuesList = getValuesList(csvReader);

		final Map<String, Object> values = valuesList.get(0);

		final String reportingEntity = (String) values.get(ENTITY_RESPONSIBLE_FOR_REPORTING);

		boolean isValid = true;

		final Map<String, Object> documentContext = new HashMap<>();
		documentContext.put("StringUtils", StringUtils.class);
		documentContext.put("valuesList", valuesList);
		documentContext.put("numberOfRecords", valuesList.size());
		final String documentXML = mergeTemplate(DOCUMENT_VTL, documentContext);

		isValid &= validateXML(documentXML);

		final Date today = new Date();

		final Map<String, Object> wrapperContext = new HashMap<>();
		wrapperContext.put("payload", documentXML);
		wrapperContext.put("executionAgentRCP", reportingEntity);

		// A random number between 1 and 1M
		final String businessMessageId = Integer.toString(ran.nextInt(1000000) + 1);

		// From – must contain an O-code identifying the sender
		// To – identifies the receiver of the submission i.e. DDRIE
		// Business Message ID - holds a submission identification
		// Message Definition ID – identifies the schema reflected in the Payload
		// Creation Date – contains the submission creation date
		wrapperContext.put("from", ocode);
		wrapperContext.put("to", "DDRIE"); // DDRIE: DTCC Data Repository (Ireland) PLC
		wrapperContext.put("businessMessageId", businessMessageId);
		wrapperContext.put("messageDefinitionId", "auth.030.001.03");
		wrapperContext.put("creationDate", sdfYYYYMMDDTHHMMSSZ.format(today));

		final String wrapperXML = mergeTemplate(DTCC_WRAPPER_VTL, wrapperContext);

		final StringBuilder fileName = new StringBuilder();
		if (environment != null && sysId != null) {
			fileName.append(String.format(FILE_NAME_FORMAT, environment, ocode, sysId));
		} else {
			fileName.append(FilenameUtils.removeExtension(csvReader.getFileName()));
		}
		fileName.append(FILE_EXTENSION);

		final File file = new File(outputDir, fileName.toString());
		if (file.exists()) {
			logger.warn("File {} already exists. Will be overwritten.", file.getAbsolutePath());
		}
		writeXML(file, wrapperXML);

		return isValid;
	}

	/**
	 * Merges the {@code templateName} with the {@code context}.
	 *
	 * @param templateName the Velocity template name
	 * @param context      the Velocity context
	 * @return the {@code templateName} with the substituted values from the
	 *         {@code context}
	 */
	private String mergeTemplate(final String templateName, final Map<String, Object> context) {

		final Template template = velocityEngine.getTemplate(templateName);
		final VelocityContext velocityContext = new VelocityContext(context);
		final StringWriter writer = new StringWriter();
		template.merge(velocityContext, writer);
		return writer.toString();
	}

	/**
	 * Validates the {@code xml} against the {@code xsd}.
	 *
	 * @param xml the XML as string
	 * @return true if the {@code xml} validation is success, false otherwise
	 */
	private boolean validateXML(final String xml) {

		final CustomSAXErrorHandler errorHandler = new CustomSAXErrorHandler();
		final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		String name = ESMAUG_DATTAR_XSD;
		if (null == getClass().getResource(ESMAUG_DATTAR_XSD)) {
			name = name.substring(1);
		}
		try (StringReader reader = new StringReader(xml); InputStream is = getClass().getResourceAsStream(name)) {
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, Boolean.FALSE);
			final Source schemaFile = new StreamSource(is);
			final Schema schema = factory.newSchema(schemaFile);
			final Validator validator = schema.newValidator();
			validator.setErrorHandler(errorHandler);
			validator.validate(new StreamSource(reader));
		} catch (final Exception e) {
			logger.error("Exception when validating the XML", e);
			return false;
		}

		final boolean isValid = errorHandler.isValid();
		if (isValid) {
			logger.info("XML validation success");
		} else {
			logger.error("XML validation failed. Number of errors: {}", errorHandler.getErrors().size());
			errorHandler.getErrors().forEach(logger::error);
		}
		return isValid;
	}

	/**
	 * Writes the {@code xml} to the {@code file}.
	 *
	 * @param file the output file
	 * @param xml  the XML as string
	 */
	private void writeXML(final File file, final String xml) {

		final OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndentSize(2);
		format.setSuppressDeclaration(false);
		format.setEncoding("UTF-8");

		try (FileWriter fileWriter = new FileWriter(file)) {
			final Document document = DocumentHelper.parseText(xml);
			final XMLWriter xmlWriter = new XMLWriter(fileWriter, format);
			xmlWriter.write(document);
		} catch (final IOException | DocumentException e) {
			logger.error("Exception when writting the XML file", e);
		}

		logger.info("File exported to {}", file.getAbsolutePath());
	}

	private List<Map<String, Object>> getValuesList(final CsvReader csvReader) {
		final List<Map<String, Object>> values = new ArrayList<>();
		final String[] header = csvReader.getHeader();
		csvReader.getRows().forEach(row -> {
			final Map<String, Object> map = new HashMap<>();
			// Avoid null values
			EmirRefitColumns.getColumnNames().forEach(columnName -> map.put(columnName, ""));
			for (int i = 0; i < header.length; i++) {
				final String key = header[i];
				final String value = row[i];
				map.put(key, value);
			}
			values.add(map);
		});
		return values;
	}
}
