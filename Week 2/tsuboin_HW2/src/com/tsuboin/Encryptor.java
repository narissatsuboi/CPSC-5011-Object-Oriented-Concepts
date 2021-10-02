/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin;

public interface Encryptor {
	
	/**
	 * Encrypts the passed in string
	 * @param s The string to encrypt
	 * @return  The encrypted string
	 */
	String encrypt(String s);
	
	/**
	 * Decrypts the passed in string
	 * @param s The string to decrypt
	 * @return  The (plaintext) decrypted string
	 */
	String decrypt(String s);
	
}