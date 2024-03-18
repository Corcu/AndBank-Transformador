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

/**
 * CSV to XML Launcher.
 * 
 * @author luis.aguilar@devone.es
 * @version 1.0.1
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Csv2XmlLauncher {

	private static Logger logger = LoggerFactory.getLogger(Csv2XmlLauncher.class);

	public static void main(final String[] args) {

		boolean success = false;

		final Csv2XmlApp app = new Csv2XmlApp();
		try {
			success = app.launch(args);
		} catch (final Exception e) {
			logger.error("Error while launching the application", e);
		}

		System.exit(success ? 0 : 1);
	}

}
