/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin.driver;

import com.tsuboin.exceptions.*;
import com.tsuboin.vault.PasswordVault;
import org.junit.Test;


// GRADER - PLEASE RUN TEST BY TEST (1-5). RUNNING FROM DRIVER DEFINITION
// RUNS THEM IN RANDOM ORDER.

/**
 * This Junit test replaces the Driver to show the test cases.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Driver {

	/**
	 * Test prints successful execution of newNewUser, add newSite,
	 * retrieveSitePassword, and updateSitePassword.
	 */
	@Test
	public void testSuccessCase() {
		System.out.println("** 1. Testing success case: **");
		// Test 1a - addNewUser successfully
		PasswordVault my_vault = new PasswordVault();
		String[] test = {"sheila", "mypass123!", "amazon"};

		try {
			System.out.println("Attempting to add user '" + test[0] + "' and " +
				"password '" + test[1] + "'");
			my_vault.addNewUser(test[0], test[1]);
			System.out.println("Added user '" + test[0]);
		} catch (Exception e) {
			System.out.println("FAIL: addNewUser success case");
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 1b - addNewSite Successfully
		try {
			System.out.println("Attempting to add site '" + test[2] + "' for user '" +
				test[0] + "'");
			String sitepassword = my_vault.addNewSite(test[0], test[1],
				test[2]);
			System.out.println("Added site '" + test[2] + "' for user '" + test[0] +
				"' => generated password: " + sitepassword);
		} catch (Exception e) {
			System.out.println("FAIL: addNewSite success case");
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 1c - retrieveSitePassword Successfully
		try {
			System.out.println("Attempting to retrieve '" + test[2] + "' " +
				"site password for " + "user '" + test[0] + "'");
			String sitepassword = my_vault.retrieveSitePassword(test[0],
				test[1], test[2]);
			System.out.println("Retrieved site password for user '" + test[0] +
				"' => retrieved passsword: " + sitepassword);
		} catch (Exception e) {
			System.out.println("FAIL: retrieveSitePassword success case");
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 1d - updateSitePassword Successfully
		try {
			System.out.println("Attempting to update '" + test[2] + "' site " +
				"password for user '" + test[0] + "'");
			String sitepassword = my_vault.updateSitePassword(test[0],
				test[1], test[2]);
			System.out.println("Update site '" + test[2] + "' for user " +
				"'" + test[0] + "' => updated password: " + sitepassword);
		} catch (Exception e) {
			System.out.println("FAIL: updateSitePassword success case");
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	/**
	 * Test demonstrates appropriate exceptions are thrown when addNewUser
	 * is called with invalid input. InvalidUserName, InvalidPassword
	 */
	@Test
	public void testExceptionsAddNewUser()
		throws DuplicateUserException, InvalidPasswordException,
		InvalidUsernameException {
		System.out.println("** 2. Testing exceptions for addNewUser: **");
		// Test 2a - Invalid Username Exception
		PasswordVault my_vault = new PasswordVault();

		try {
			System.out.println("Attempting to add user 'bob' and password " +
				"'mypass123!");
			my_vault.addNewUser("bob", "mypass123!'");
		} catch (InvalidUsernameException | InvalidPasswordException |
			DuplicateUserException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		// Test 2b  - Invalid Password Exception
		try {
			System.out.println("Attempting to add user 'bobismyname' and " +
				"password 'mypass123'");
			my_vault.addNewUser("bobismyname", "mypass123");
		} catch (InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 2c  - Duplicate User Name
		try {
			my_vault.addNewUser("sheila", "mypass123!");
			System.out.println("Attempting to add user 'sheila' and password " +
				"'mypass123!'");
			my_vault.addNewUser("sheila", "mypass123!");
		} catch (DuplicateUserException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Test demonstrates appropriate exceptions are thrown when
	 * addNewSite is called with invalid input. DuplicateSite,
	 * UserNotFound, InvalidSite.
	 *
	 * @throws InvalidUsernameException
	 * @throws DuplicateUserException
	 * @throws InvalidPasswordException
	 * @throws UserNotFoundException
	 * @throws UserLockedOutException
	 * @throws PasswordMismatchException
	 * @throws InvalidSiteException
	 * @throws DuplicateSiteException
	 */
	@Test
	public void testExceptionsAddNewSite()
		throws InvalidUsernameException, DuplicateUserException,
		InvalidPasswordException, UserNotFoundException,
		UserLockedOutException, PasswordMismatchException,
		InvalidSiteException, DuplicateSiteException {
		System.out.println("** 3. Testing exceptions for addNewSite: **");

		PasswordVault my_vault = new PasswordVault();
		my_vault.addNewUser("sheila", "mypass123!");
		// Test 3a - DuplicateSiteException
		try {
			my_vault.addNewSite("sheila", "mypass123!",
				"amazon");
			System.out.println("Attempting to add site 'amazon' for user " +
				"'sheila'");
			my_vault.addNewSite("sheila", "mypass123!",
				"amazon");
		} catch (DuplicateSiteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 3b - UserNotFoundException
		try {
			System.out.println("Attempting to add site 'amazon' for user " +
				"'maryismyname'");
			my_vault.addNewSite("maryismyname", "mypass123!",
				"amazon");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 3c - InvalidSiteName
		try {
			System.out.println("Attempting to add site 'amazon.com' for user " +
				"'sheila'");
			my_vault.addNewSite("sheila", "mypass123!",
				"amazon.com");
		} catch (InvalidSiteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	/**
	 * Tests SiteNotFound exception is thrown by retrieveSitePassword
	 * when a site is input that isn't already stored.
	 *
	 * @throws InvalidUsernameException
	 * @throws DuplicateUserException
	 * @throws InvalidPasswordException
	 * @throws UserNotFoundException
	 * @throws UserLockedOutException
	 * @throws PasswordMismatchException
	 * @throws InvalidSiteException
	 * @throws DuplicateSiteException
	 */
	@Test
	public void testExceptionsRetrieveSitePassword()
		throws InvalidUsernameException, DuplicateUserException,
		InvalidPasswordException, UserNotFoundException,
		UserLockedOutException, PasswordMismatchException,
		InvalidSiteException, DuplicateSiteException {
		System.out.println("** 4. Testing exceptions for " +
			"retrieveSitePassword: **");
		PasswordVault my_vault = new PasswordVault();
		my_vault.addNewUser("sheila", "mypass123!");
		my_vault.addNewSite("sheila", "mypass123!",
			"safeway");
		try {
			System.out.println("Attempting retrieve 'amazon' site password " +
				"for user 'sheila'");
			my_vault.retrieveSitePassword("sheila",
				"mypass123!", "amazon");
		} catch (SiteNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Tests appropriate exceptions are thrown for updateSitePassword
	 * when invalid input is entered. SiteNotFound, PasswordMismatch,
	 * UserLockOut.
	 *
	 * @throws SiteNotFoundException
	 * @throws InvalidUsernameException
	 * @throws DuplicateUserException
	 * @throws InvalidPasswordException
	 * @throws UserNotFoundException
	 * @throws UserLockedOutException
	 * @throws PasswordMismatchException
	 * @throws InvalidSiteException
	 * @throws DuplicateSiteException
	 */
	@Test
	public void testExceptionsUpdateSitePassword()
		throws SiteNotFoundException, InvalidUsernameException,
		DuplicateUserException, InvalidPasswordException,
		UserNotFoundException, UserLockedOutException,
		PasswordMismatchException, InvalidSiteException,
		DuplicateSiteException {
		System.out.println("** 5. Testing exceptions for updateSitePassword: " +
			"**");
		PasswordVault my_vault = new PasswordVault();
		my_vault.addNewUser("sheila", "mypass123!");
		my_vault.addNewSite("sheila", "mypass123!",
			"safeway");
		// Test 4a - SiteNotFound
		try {
			System.out.println("Attempting to update 'amazon' site password " +
				"for user 'sheila'");
			my_vault.retrieveSitePassword("sheila",
				"mypass123!", "amazon");
		} catch (SiteNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 4b - PasswordMismatch
		try {
			System.out.println("Attempting to update 'amazon' site password " +
				"for user 'sheila'");
			my_vault.retrieveSitePassword("sheila", "whoops!",
				"amazon");
		} catch (PasswordMismatchException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		// Test 4c - UserLockout
		try {
			System.out.println("Attempting to update 'amazon' site password " +
				"for user 'sheila'");
			my_vault.retrieveSitePassword("sheila", "whoops!",
				"amazon");
		} catch (PasswordMismatchException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		try {
			System.out.println("Attempting to update 'amazon' site password " +
				"for user 'sheila'");
			my_vault.retrieveSitePassword("sheila", "whoops!",
				"amazon");
		} catch (UserLockedOutException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
}


