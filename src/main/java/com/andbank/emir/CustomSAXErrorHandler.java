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
 * Custom SAX Error Handler.
 * 
 * @author luis.aguilar@devone.es
 * @version 1.0.1
 */
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class CustomSAXErrorHandler implements ErrorHandler {

	private boolean isValid = true;

	private final List<String> errors = new ArrayList<>();

	public boolean isValid() {
		return isValid;
	}

	public List<String> getErrors() {
		return errors;
	}

	@Override
	public void warning(final SAXParseException ex) {
		errors.add("Warning: " + ex);
	}

	@Override
	public void error(final SAXParseException ex) {
		logError(ex);
	}

	@Override
	public void fatalError(final SAXParseException ex) {
		logError(ex);
	}

	private void logError(final SAXParseException ex) {
		String message = "" + ex; // It gives more details rather than ex.getMessage()
		message = message.replace("org.xml.sax.SAXParseException;", ""); // remove unnecessary information
		errors.add(message);
		isValid = false;
	}
}
