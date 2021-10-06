/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin.vault;

import com.tsuboin.encrypt.CaesarCipher;
import com.tsuboin.exceptions.*;

import java.util.HashMap;
import java.util.Random;

/**
 * PasswordVault is given username, password, and the name of a website
 * to store for a user. When the user so desires, they can retrieve the
 * password for a site, update the password, or add a new site. PasswordVault
 * stores passwords encrypted.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class PasswordVault implements Vault {

	/**
	 * Instantiates PasswordVault object and member fields including
	 * InputValidator and CaesarCipher objects; hashmaps for data storage.
	 */
	public PasswordVault() {
		this.input_checker = new InputValidator();
		this.user_password_map = new HashMap<>();
		this.user_sites_passwords = new HashMap<>();
		this.user_lockout_map = new HashMap<>();
		this.cipher = new CaesarCipher();
	}

	/**
	 * Overloaded construction instantiates the PasswordVault object
	 * with a external CaesarCipher object.
	 * Included per spec but not needed/not used.
	 *
	 * @param cipher CaesarCipher object
	 */
	public PasswordVault(CaesarCipher cipher) {
		this.input_checker = new InputValidator();
		this.user_password_map = new HashMap<>();
		this.user_sites_passwords = new HashMap<>();
		this.user_lockout_map = new HashMap<>();
		this.cipher = cipher;
	}


	/**
	 * Add a new user to the vault (with no site passwords). For
	 * example, a username and password is supplied, and the system
	 * does no verification or checking except that the username and
	 * password must be in correct formats, and the username cannot
	 * already be in the vault.
	 *
	 * @param username The username to be added
	 * @param password The password to be associated with this user
	 * @throws InvalidUsernameException The supplied username is invalid
	 * @throws InvalidPasswordException The supplied password is invalid
	 * @throws DuplicateUserException   The username is already in the vault
	 */
	@Override
	public void addNewUser(String username, String password)
		throws InvalidUsernameException,
		InvalidPasswordException,
		DuplicateUserException {
		///////////Input Validation///////////////////////////////////
		// Check for DuplicateUser
		if (user_password_map != null && user_password_map.containsKey(username)) {
			throw new DuplicateUserException();
		}
		// Check for InvalidUsername
		if (!input_checker.is_valid_username(username)) {
			throw new InvalidUsernameException();
		}
		// Check for InvalidPassword
		if (!input_checker.is_valid_password(password)) {
			throw new InvalidPasswordException();
		}

		///////////Function///////////////////////////////////////////

		// Add new user and password to user_pass hashmap
		user_password_map.put(username, cipher.encrypt(password));
		// Update user lockout count to 0
		user_lockout_map.put(username, 0);
	}

	/**
	 * Adds a new site to the vault for the user, generates, stores, and
	 * returns a password for that site. For example, if a user is creating
	 * an account at the site "amazon" for the first time, he/she calls the
	 * vault with the site name, and the site makes up a password for the
	 * user/site, returns the (plain text password to the user, and stores
	 * the (encrypted) password -- all stored passwords in the vault.
	 *
	 * @param username The username requesting the new site password
	 * @param password Password for the username
	 * @param sitename Name of the site for which the user is requesting a password
	 * @return A new (plaintext) password for the requested site
	 * @throws DuplicateSiteException    There is already a site stored for this
	 *                                   user
	 * @throws UserNotFoundException     There is no such user in the vault
	 * @throws UserLockedOutException    The user has been locked out due to too
	 *                                   many incorrect password attempts
	 * @throws PasswordMismatchException The password supplied does not match the
	 *                                   user's vault password
	 * @throws InvalidSiteException      The site name supplied is invalid
	 */
	public String addNewSite(String username, String password, String sitename)
		throws DuplicateSiteException,
		UserNotFoundException,
		UserLockedOutException,
		PasswordMismatchException,
		InvalidSiteException {
		String sitepassword;
		///////////Input Validation///////////////////////////////////
		// Check for UserNotFound, PasswordMismatch and Userlockout
		loginExceptions(username, password);

		// Check for 'site' valid formaat
		char[] ch = sitename.toCharArray();
		for (char c : ch) {
			if (!Character.isLowerCase(c)) {
				throw new InvalidSiteException();
			}
		}

		// Check for DuplicateSite
		if (user_sites_passwords.containsKey(username.concat(sitename))) {
			throw new DuplicateSiteException();
		}

		///////////Function///////////////////////////////////////////
		// New site, get new site password
		sitepassword = generateRandomPassword();

		// Store new site and encrypted site password
		user_sites_passwords.put(username.concat(sitename),
			cipher.encrypt(sitepassword));
		return sitepassword;  // return decrypted site password
	}

	/**
	 * Generate, store, and return an updated password for a site associated
	 * with the user. For example, the user wants to change his/her password on
	 * "amazon," and the system generates a new password, stores an encrypted
	 * version for the user, and returns the plaintext version.
	 *
	 * @param username The username requesting the new site password
	 * @param password Password for the username
	 * @param sitename Name of the site for which the user is requesting a password
	 * @return An updated (plaintext) password for the requested site
	 * @throws SiteNotFoundException     The user has no password associated with
	 *                                   this site
	 * @throws UserNotFoundException     There is no such user in the vault
	 * @throws UserLockedOutException    The user has been locked out due to too
	 *                                   many incorrect password attempts
	 * @throws PasswordMismatchException The password supplied does not match the
	 *                                   user's vault password
	 */
	@Override
	public String updateSitePassword(String username, String password,
	                                 String sitename)
		throws SiteNotFoundException,
		UserNotFoundException,
		UserLockedOutException,
		PasswordMismatchException {
		String newPassword;
		String user_site_key = username.concat(sitename);

		///////////Input Validation///////////////////////////////////
		// Check for UserNotFound, PasswordMismatch and Userlockout
		loginExceptions(username, password);

		// Check site exists in vault
		if (!user_sites_passwords.containsKey(user_site_key)) {
			throw new SiteNotFoundException();
		}

		///////////Function///////////////////////////////////////////
		// Generate new password
		newPassword = generateRandomPassword();

		// Replace it in the user_site_passwords map
		user_sites_passwords.replace(user_site_key,
			cipher.encrypt(newPassword));

		return newPassword;
	}

	/**
	 * Retrieve the (plaintext) password for the user for the requested site.
	 * For example, the user supplies the name of a site, and if she has a
	 * stored password for the site, it is returned in plain text.
	 *
	 * @param username The username requesting the site password
	 * @param password Password for the username
	 * @param sitename Name of the site for which the user is requesting a password
	 * @return The (plaintext) password for the requested site
	 * @throws SiteNotFoundException     The user has no password associated with
	 *                                   this site
	 * @throws UserNotFoundException     There is no such user in the vault
	 * @throws UserLockedOutException    The user has been locked out due to too
	 *                                   many incorrect password attempts
	 * @throws PasswordMismatchException The password supplied does not match the
	 *                                   user's vault password
	 */
	@Override
	public String retrieveSitePassword(String username, String password,
	                                   String sitename)
		throws SiteNotFoundException,
		UserNotFoundException,
		UserLockedOutException,
		PasswordMismatchException {
		String user_site_key = username.concat(sitename);

		///////////Input Validation///////////////////////////////////
		// Check for UserNotFound, PasswordMismatch and Userlockout
		loginExceptions(username, password);

		// Check site exists in vault
		if (!user_sites_passwords.containsKey(user_site_key)) {
			throw new SiteNotFoundException();
		}

		///////////Function///////////////////////////////////////////
		return cipher.decrypt(user_sites_passwords.get(user_site_key));
	}

	/**
	 * Increments the Integer value stored at teh given key.
	 *
	 * @param map Hashmap<K, Integer>
	 * @param key key to update the value for
	 * @param <K> accepts Strings, Integers, etc
	 */
	private static <K> void incrementMapCount(HashMap<K, Integer> map, K key) {
		// update the counter value stored in map by 1
		int count = map.getOrDefault(key, 0);
		map.put(key, count + 1);
	}

	/**
	 * Creates a password between 6-15 characters in length with 1 dig,
	 * 1 uppercase character, 1, special character, and characters a-z.
	 *
	 * @return String representing a password
	 */
	private String generateRandomPassword() {
		Random rand = new Random();
		int MIN_LEN = 6;
		int MAX_LEN = 15;
		int numDigits = 1;
		int numUppercase = 1;
		int numSpecialChars = 1;
		char[] temp = PasswordGenerator.generatePassword(MIN_LEN, MAX_LEN, numDigits,
			numUppercase, numSpecialChars);
		return new String(temp);
	}

	/**
	 * Checks username and password for UserNotFound, PasswordMismatch,
	 * and UserLockedOut.
	 *
	 * @param username The username requesting the site password
	 * @param password Password for the username
	 * @throws UserNotFoundException     There is no such user in the vault
	 * @throws UserLockedOutException    The user has been locked out due to too
	 * 	                                 many incorrect password attempts
	 * @throws PasswordMismatchException The password supplied does not match
	 *                                   the user's vault password
	 */
	private void loginExceptions(String username, String password)
		throws UserNotFoundException,
		UserLockedOutException,
		PasswordMismatchException {
		// Check for UserNotFound
		if (!user_password_map.containsKey(username)) {
			throw new UserNotFoundException();
		}
		// Check for PasswordMismatch, UserLockout
		if (!user_password_map.get(username).equals(cipher.encrypt(password))) {
			// Update count of lockouts
			incrementMapCount(user_lockout_map, username);
			// Check if 3 or more lockouts have occurred
			if (user_lockout_map.get(username) > 2) {
				throw new UserLockedOutException();
			} else {
				throw new PasswordMismatchException();
			}
		}
	}

	/** This PasswordVault's InputValidation object */
	InputValidator input_checker;

	/** This PasswordVault's CCipher object */
	CaesarCipher cipher;

	/** Username:Password hashmap */
	HashMap<String, String> user_password_map;

	/** Username:Number of lockouts */
	HashMap<String, Integer> user_lockout_map;

	/** Hashmap {Users+site : encrypted password} */
	HashMap<String, String> user_sites_passwords;
}
