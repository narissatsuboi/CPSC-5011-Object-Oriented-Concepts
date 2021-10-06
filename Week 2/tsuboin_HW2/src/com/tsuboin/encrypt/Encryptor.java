/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin.encrypt;

/**
 * An encryption in the scope of this interface is a string modified
 * to another state from its original form and then returned.
 * A decryption is taking the modified string and returning it to its
 * original form. The Encryption interface provides a string to string
 * encryption operation and a string to string decryption operation.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public interface Encryptor {

	/**
	 * Encrypts the passed in string
	 *
	 * @param s The string to encrypt
	 * @return The encrypted string
	 */
	String encrypt(String s);

	/**
	 * Decrypts the passed in string
	 *
	 * @param s The string to decrypt
	 * @return The (plaintext) decrypted string
	 */
	String decrypt(String s);
}