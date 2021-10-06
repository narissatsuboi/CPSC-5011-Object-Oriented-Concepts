/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin.vault;
import java.util.Random;

/**
 * PasswordGenerator creates a random password with upper or lowercase letters,
 * digits between 0 and 9, and special characters of the set !@#$%^&.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public final class PasswordGenerator {
	/** Range of uppercase letters in set.*/
	private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/** Range of lowercase letters in set.*/
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	/** Range of digits in set.*/
	private static final String NUM = "0123456789";
	/** Range of special characters in set.*/
	private static final String SPL_CHARS = "!@#$%^&";


	/**
	 * Generates a random password password restrictions.
	 *
	 * @param minLen Minimum length of password
	 * @param maxLen Maximum length of password
	 * @param numUppercase Number of uppercase characters
	 * @param numDigits Number of digits from 0-9
	 * @param numSpecialChars Number of special characters from set
	 * @return String representing a password
	 */
	public static char[] generatePassword(int minLen, int maxLen, int numUppercase,
	                                      int numDigits, int numSpecialChars) {
		if (minLen > maxLen) {
			throw new IllegalArgumentException("Min. Length > Max. Length!");
		}

		Random rand = new Random();

		int len = rand.nextInt(maxLen - minLen + 1) + minLen;
		char[] password = new char[len];
		int index = 0;

		for (int i = 0; i < numUppercase; i++) {
			index = getNextIndex(rand, len, password);
			password[index] = ALPHA_CAPS.charAt(rand.nextInt(ALPHA_CAPS.length()));
		}
		for (int i = 0; i < numDigits; i++) {
			index = getNextIndex(rand, len, password);
			password[index] = NUM.charAt(rand.nextInt(NUM.length()));
		}
		for (int i = 0; i < numSpecialChars; i++) {
			index = getNextIndex(rand, len, password);
			password[index] = SPL_CHARS.charAt(rand.nextInt(SPL_CHARS.length()));
		}
		for (int i = 0; i < len; i++) {
			if (password[i] == 0) {
				password[i] = ALPHA.charAt(rand.nextInt(ALPHA.length()));
			}
		}
		return password;
	}

	/**
	 * Generates random index for next character to be placed.
	 *
	 * @param rand Random object
	 * @param len Len of the string
	 * @param password Password stored as a character array
	 *
	 * @return Index of next character to be placed
	 */
	private static int getNextIndex(Random rand, int len, char[] password) {
		int index = rand.nextInt(len);
		while (password[index = rand.nextInt(len)] != 0) {
		}
		return index;
	}

}
