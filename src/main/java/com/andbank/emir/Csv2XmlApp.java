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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CSV to XML Application.
 * 
 * @author luis.aguilar@devone.es
 * @version 1.0.1
 */
public class Csv2XmlApp {

	private static Logger logger = LoggerFactory.getLogger(Csv2XmlApp.class);

	// Options
	private static final String INPUT_DIR = "inputDir";
	private static final String OUTPUT_DIR = "outputDir";
	private static final String ENVIRONMENT = "environment";
	private static final String OCODE = "ocode";
	private static final String SYSID = "sysid";

	public boolean launch(final String[] args) throws ParseException, IOException {

		final Options options = new Options();
		options.addOption(new Option("i", INPUT_DIR, true, "The path to the input directory :: Mandatory"));
		options.addOption(new Option("o", OUTPUT_DIR, true, "The path to the output directory :: Mandatory"));
		options.addOption(new Option("c", OCODE, true, "the O-code :: Mandatory"));
		options.addOption(new Option("e", ENVIRONMENT, true, "The environment (UAT = DTS4, Prod = DTS3) :: Optional"));
		options.addOption(new Option("s", SYSID, true, "the DataTrak SYSID :: Optional"));

		final CommandLineParser parser = new DefaultParser();
		final CommandLine cmd = parser.parse(options, args);

		if (!cmd.hasOption(INPUT_DIR) || !cmd.hasOption(OUTPUT_DIR) || !cmd.hasOption(OCODE)) {
			logger.error("Please check Program arguments");
			logger.info(options.toString());
			return false;
		}

		boolean success = true;

		final String inputDir = cmd.getOptionValue(INPUT_DIR);
		final String outputDir = cmd.getOptionValue(OUTPUT_DIR);
		final String environment = cmd.getOptionValue(ENVIRONMENT);
		final String ocode = cmd.getOptionValue(OCODE);
		final String sysId = cmd.getOptionValue(SYSID);

		final File inputFile = getInputFile(inputDir);
		logger.info("Processing file {}", inputFile.getAbsolutePath());

		final CsvReader csvReader = new CsvReader(inputFile);
		final Csv2XmlUtil util = new Csv2XmlUtil();
		success = util.exportAsXML(outputDir, environment, ocode, sysId, csvReader);

		if (success) {
			final File archiveDir = new File(inputDir, "archive");
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			final File archivedFile = new File(archiveDir, inputFile.getName() + "_" + sdf.format(new Date()));
			if (inputFile.renameTo(archivedFile)) {
				logger.info("Archived file {}", archivedFile.getAbsolutePath());
			} else {
				logger.error("Couldn't archive file {}", inputFile.getAbsolutePath());
			}
		}

		return success;
	}

	private File getInputFile(final String pathname) throws IOException {

		final File inputDir = new File(pathname);
		if (!inputDir.exists()) {
			throw new IOException("Input directory doesn't exist");
		}

		final List<File> files = (List<File>) FileUtils.listFiles(inputDir, new String[] { "csv" }, false);
		if (files.size() == 1) {
			return files.get(0);
		}

		throw new IOException("Only one file with extension .csv is allowed in the input directory");
	}
}
