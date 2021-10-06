package com.tsuboin.exceptions;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * DuplicateSiteExceptions are thrown when the supplied site is
 * already stored in the vault for that user.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class DuplicateSiteException extends Exception
{
	public DuplicateSiteException()
	{
		super("Error: The site name already exists for this user.");
	}
}
