package com.tsuboin.exceptions;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * InvalidPasswordExceptions are thrown when the password supplied
 * does not match the user's vault password.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class PasswordMismatchException extends Exception
{
	public PasswordMismatchException()
	{
		super("Error: Attempted to login with incorrect credentials.");
	}
}
