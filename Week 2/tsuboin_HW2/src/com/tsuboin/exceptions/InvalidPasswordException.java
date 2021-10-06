package com.tsuboin.exceptions;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * InvalidPasswordExceptions are thrown when the supplied password
 * is invalid.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class InvalidPasswordException extends Exception
{
	public InvalidPasswordException()
	{
		super("Error: The password is invalid; enter 6-15 lowercase " +
			"characters and at least one letter, one number, and one " +
			"special character (!@#$%^&).");
	}
}
