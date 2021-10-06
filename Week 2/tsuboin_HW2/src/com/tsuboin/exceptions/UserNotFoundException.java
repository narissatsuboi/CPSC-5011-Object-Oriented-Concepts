package com.tsuboin.exceptions;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * UserNotFoundExceptions are thrown when there is no such user in
 * the vault.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("Error: Username does not exist.");
	}
}
