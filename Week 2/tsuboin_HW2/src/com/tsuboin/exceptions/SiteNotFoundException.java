package com.tsuboin.exceptions;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * SiteNotFoundExceptions are thrown when the user has no password
 * associated with this site.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class SiteNotFoundException extends Exception {
	public SiteNotFoundException() {
		super("Error: Site name does not exist for this user.");
	}
}
