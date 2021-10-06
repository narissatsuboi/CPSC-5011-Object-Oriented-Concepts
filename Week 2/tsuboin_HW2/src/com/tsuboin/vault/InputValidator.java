package com.tsuboin.vault;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * InputValidation parses input usernames and passwords for conformance with
 * predetermined criteria.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class InputValidator {

	/**
	 * Default constructor.
	 */
	public InputValidator() {
	}

	/**
	 * Input validation object accepts other regex than default.
	 *
	 * @param other_regex another regex string
	 */
	public InputValidator(String other_regex) {
		this.pw_regex = other_regex;
	}


	/**
	 * Validates username conforms with predetermined criteria.
	 * Username must be all lowercase between 6-12 chars.
	 *
	 * @param user String username
	 * @return True if valid
	 */
	public boolean is_valid_username(String user) {
		// Validate length
		if (6 > user.length() || user.length() > 12) {
			return false;
		}

		// Convert string to char array
		char[] char_user = user.toCharArray();

		// if any character is not lowercase, return false
		for (char c : char_user) {
			if (!Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Validates vault password conforms with predetermined criteria.
	 *
	 * @param pass String password
	 * @return True if password s vaid
	 */
	public boolean is_valid_password(String pass) {
		Pattern pattern = Pattern.compile(pw_regex);
		Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}


	/**
	 * Default regex
	 * 6-15 characters in length
	 * Contains at least one letter upper or lower
	 * Contains at least one digit
	 * Contains at least one special character from the set !@#$%^&
	 */
	private String pw_regex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&]).{6," +
		"15}$";
}
