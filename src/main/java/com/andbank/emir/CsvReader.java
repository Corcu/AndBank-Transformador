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
import java.util.ArrayList;
import java.util.List;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

/**
 * CSV Reader.
 * 
 * @author luis.aguilar@devone.es
 * @version 1.0.1
 */
public class CsvReader {

	private final String fileName;
	private String[] header;
	private final List<String[]> rows = new ArrayList<>();

	public CsvReader(final File file) {
		fileName = file.getName();
		read(file);
	}

	private void read(final File file) {
		final CsvParserSettings settings = new CsvParserSettings();
		settings.detectFormatAutomatically();
		final CsvParser parser = new CsvParser(settings);
		final List<Record> records = parser.parseAllRecords(file);
		if (!records.isEmpty()) {
			header = records.get(0).getMetaData().headers();
			records.remove(0); // Remove header
			records.forEach(r -> {
				final int length = r.getMetaData().headers().length;
				final String[] row = new String[length];
				for (int i = 0; i < length; i++) {
					row[i] = r.getValue(i, "");
				}
				rows.add(row);
			});
		}
	}

	public String getFileName() {
		return fileName;
	}

	public String[] getHeader() {
		return header;
	}

	public List<String[]> getRows() {
		return rows;
	}

	public int getNumberOfRows() {
		return rows.size();
	}
}
