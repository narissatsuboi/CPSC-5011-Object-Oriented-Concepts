package com.tsuboin.exceptions;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * DuplicateUserExceptions are thrown when the username is already
 * in the vault.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class DuplicateUserException extends Exception
{
	public DuplicateUserException()
	{
		super("Error: The username already exists.");
	}
}
