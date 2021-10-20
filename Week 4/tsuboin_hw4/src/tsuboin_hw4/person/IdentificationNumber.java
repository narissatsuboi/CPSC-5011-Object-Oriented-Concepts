package tsuboin_hw4.person;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * SUID class increments and issues Seattle University ID numbers from 100000+.
 * For use by Faculty and Student constructors.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class IdentificationNumber {

	/**
	 * Generates the next SUID (1 value greater than the last).
	 *
	 * @return SUID number
	 */
	public static int get_new_SUID() {
		return ++current_ID;
	}

	/**  Stores latest SUID number */
	static int current_ID = 999999;
}
