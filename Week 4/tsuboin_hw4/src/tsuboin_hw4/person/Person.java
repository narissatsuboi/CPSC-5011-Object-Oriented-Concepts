package tsuboin_hw4.person;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.PersonStatus;

/**
 * The Person class holds information about a campus community member.
 *
 * first name:            first name of the student
 * last name:             last name of the student
 * suid:                  Seattle U identification number
 * status:                the status of the student (see PersonStatus
 *                        enum)
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Person {

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.suid = idNumber.get_new_SUID();
		this.status = PersonStatus.ACTIVE;
	}

	/* Getters */
	public String getFirstName() {return this.firstName;}

	public String getLastName()  {return this.lastName;}

	public int getSuid() {return this.suid;}

	public PersonStatus getStatus() {return this.status;}

	public String getPersonKey() {
		return this.firstName + this.lastName + this.suid;
	}

	/** Community member's first name */
	String firstName;

	/** Community member's last name */
	String lastName;

	/** Seattle U Identification Number */
	int suid;

	/** Status see PersonStatus - All new Persons ACTIVE by default */
	PersonStatus status;

}
