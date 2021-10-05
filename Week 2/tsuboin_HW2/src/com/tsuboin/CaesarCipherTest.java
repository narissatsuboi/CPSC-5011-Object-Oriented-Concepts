/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin;
import static org.junit.Assert.*;  // for assert statements
import org.junit.Test; // for junit4

/**
 * This Junit4 testing program tests the methods in CaesarCipher class
 * for correct encrypt and decrypt functionality upon strings.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class CaesarCipherTest {

	/**
	 * Confirms a CaesarCipher object was successfully created upon
	 * constructor call.
	 */
	@Test
	public void testConstructor() {
		// Act
		var my_cipher = new CaesarCipher();
		// Assert
		assertNotNull(my_cipher);
	}

	/**
	 * Tests whether input string was shifted to the correct encrypted
	 * form.
	 */
	@Test
	public void testEncrypt() {
		// Arrange preconditions
		var my_cipher = new CaesarCipher();
		// Act
		String pw_encrypt = my_cipher.encrypt(my_pw);
		// Assert
		assertNotNull(my_cipher);
	}


	private String my_pw = "password";
	private String my_pw_encrypt = " "
}
