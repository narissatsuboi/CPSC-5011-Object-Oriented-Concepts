/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package com.tsuboin.encrypt;
import java.util.Random;

/**
 * The CasesarCipher class implements encrypt/decrypt methods from
 * the Encrypt interface and its own Caesar Cipher logic. The Caesar
 * Cipher encryption pattern replaces each character with that of
 * another character "shift #" of places along a given range of chars.
 * Range of encryption symbols is from ASCII 33(!) to 125 ( } ).
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class CaesarCipher implements Encryptor {

	/**
	 * Constructs a CaesarCipher encrypt/decrypter and sets the shift
	 * of the encryption.
	 */
	public CaesarCipher() {
		shift = getShift();
	}

	/**
	 * Implements Encryptor interface encrypt method, provided string
	 * by calling encryptDecrypt, private helper function.
	 *
	 * @param s The string to encrypt
	 * @return Encrypted form of s
	 */
	@Override
	public String encrypt(String s) {
		return encryptDecrypt(s, true);
	}

	/**
	 * Implements Encryptor interface decrypt method, provided prev.
	 * encrypted string. Calls encryptDecrypt, private helper function.
	 *
	 * @param s The string to decrypt
	 * @return Decrypted form of s
	 */
	@Override
	public String decrypt(String s) {
		return encryptDecrypt(s, false);
	}

	/**
	 * Calculates a random cipher shift between character range min.
	 * and max.
	 *
	 * @return Cipher shift/number of indexes to shift each char.
	 */
	private static int getShift() {
		Random r = new Random();
		int low = 1;
		int high = OFFSET_MAX - OFFSET_MIN;
		return r.nextInt(high - low) + low;
	}

	/**
	 * Validates string includes characters in between OFFSET_MIN and
	 * OFFSET_MAX. Given boolean 'True', encrypts string by shifting
	 * string 'shift' chars along the character range. Given boolean
	 * 'False', decrypts string by shifting string the same 'shift'
	 * in the opposite direction.
	 *
	 * @param s Encrypted or decrypted string
	 * @param encrypt True for encrypt, False for decrypt
	 * @return Modified string
	 * @throws IllegalArgumentException
	 */
	private String encryptDecrypt(String s, boolean encrypt) throws IllegalArgumentException {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			int indx = c, cpos;
			if (!isPositionInRange(indx))
				throw new IllegalArgumentException("String to be encrypted has unrecognized character " + c);

			if (encrypt) {
				cpos = indx + shift;
				if (cpos > OFFSET_MAX)
					cpos = OFFSET_MIN + (cpos - OFFSET_MAX);
			} else {
				cpos = indx - shift;
				if (cpos < OFFSET_MIN)
					cpos = OFFSET_MAX - (OFFSET_MIN - cpos);	
			}
			sb.append((char)cpos);
		}
		return sb.toString();		
	}

	/**
	 * Validation function for encryptDecrypt. Confirms that index is
	 * between OFFSET_MIN and OFFSET_MAX.
	 *
	 * @param indx Position in string being encrypted/decrypted
	 * @return True if in range, False if out of range
	 */
	private boolean isPositionInRange(int indx) {
		return indx >= OFFSET_MIN && indx <= OFFSET_MAX;
	}

	private int shift; // num indexes to pull swapped char from
    private static final int OFFSET_MIN = 32; // ASCII start
    private static final int OFFSET_MAX = 126;// ASCII end
}
