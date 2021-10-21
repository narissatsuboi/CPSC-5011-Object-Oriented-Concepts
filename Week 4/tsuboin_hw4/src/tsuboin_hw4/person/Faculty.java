package tsuboin_hw4.person;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.Building;
import tsuboin_hw4.enums.FacultyType;

/**
 * The Faculty class holds information about a faculty member.
 * <p>
 * first name:   first name of the faculty
 * last name:    last name of the faculty
 * suid:         SeattleU identification number
 * status:       the status of the faculty (see PersonStatus enum)
 * faculty type: the type of faculty (see FacultyType enum)
 * office:       includes building (i.e. ENGR) and room number (i.e 504)
 * email:        the school (i.e. SU) email address
 * For example, faculty Sheila Oh
 * first name:   Sheila
 * last name:    Oh
 * suid:         100013
 * status:       ACTIVE
 * faculty type: SEN_INSTRUCT
 * office (building/room):E NGR 504
 * email:        ohsh@seattleu.edu
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Faculty extends Person {

	/**
	 * Overloaded constructor instantiates Faculty object with first, last,
	 * faculty type, building, room (office number) and email. Inherits
	 * firstName, lastName, suid, and status getters from Person class.
	 *
	 * @param firstName   The first name of the faculty
	 * @param lastName    The last name of the faculty
	 * @param facultyType See FacultyType class
	 * @param building    See Building class
	 * @param room        Faculty's permanent office
	 * @param email       Faculty's email
	 */
	public Faculty(String firstName, String lastName,
	               FacultyType facultyType, Building building,
	               int room, String email) {
		super(firstName, lastName);
		this.facultyType = facultyType;
		this.building = building;
		this.room = room;
		this.email = email;
	}

	/* Getters */

	/**
	 * Returns the Faculty's type, see FacultyType class.
	 *
	 * @return FacultyType, see class.
	 */
	public FacultyType getFacultyType() {
		return facultyType;
	}

	/**
	 * Returns the Faculty's assigned building, see Building class.
	 *
	 * @return BuildingType, see class.
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * Returns the Faculty's assigned room (office).
	 *
	 * @return room, int
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * toString for faculty object.
	 *
	 * @param sb StringBuilder object
	 * @return string
	 */
	public String toString(StringBuilder sb) {
		sb.append("Name=").append(this.firstName).append(" ").
			append(this.lastName);
		sb.append(", ");
		sb.append("SUID=").append(this.suid);
		sb.append(", ");
		sb.append("Email=").append(this.email);
		sb.append(", ");
		sb.append("Status=").append(this.status);
		sb.append(", ");
		sb.append("Type=").append(this.facultyType);
		sb.append(", ");
		sb.append("Office=").append(this.building).append(" ").append(this.room);
		return sb.toString();
	}

	/* Private Fields */
	/**
	 * faculty type (see FacultyType)
	 */
	FacultyType facultyType;

	/**
	 * Assigned building on campus (see Building)
	 */
	Building building;

	/**
	 * Assigned room on campus
	 */
	int room;

	/**
	 * Seattle U email
	 */
	String email;
}
