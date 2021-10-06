package com.tsuboin.exceptions;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * InvalidSiteExceptions are thrown when the site name supplied is
 * invalid.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class InvalidSiteException extends Exception {
	public InvalidSiteException() {
		super("Error: The site name is invalid; enter 6-12 lower-case letters" +
			".");
	}
}
