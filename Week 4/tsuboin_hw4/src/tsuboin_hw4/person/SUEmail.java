package tsuboin_hw4.person;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * SUEmail generator utility class. Generates SU email given first and last
 * name.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */

public class SUEmail {

	/**
	 * SUEmail utility class returns an SU email.
	 *
	 * @param firstName             First name of new person
	 * @param lastName              Last name of new person
	 * @return Email in template lastnamefirstletteroffirstname@seattleu.edu
	 */
	public static String SUEMail(String firstName, String lastName) {
		return lastName + firstName.charAt(0) + "@seattleu.edu";
	}
}
