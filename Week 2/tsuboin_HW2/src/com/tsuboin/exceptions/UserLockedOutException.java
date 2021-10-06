package com.tsuboin.exceptions;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * UserLockedOutExceptions are thrown when the user has entered
 * too many incorrect login attempts.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class UserLockedOutException extends Exception {
	public UserLockedOutException() {
		super("Error: Attempted to login with incorrect credentials 3 times, " +
			"user is locked out of the system.");
	}
}
