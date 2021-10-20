package tsuboin_hw4.person;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.Building;
import tsuboin_hw4.enums.FacultyType;
import tsuboin_hw4.enums.PersonStatus;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 * 
 * @author Narissa Tsuboi
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
    public Faculty (String firstName, String lastName,
                   FacultyType facultyType, Building building,
                   int room, String email) {
        // TODO: implement Faculty constructor
        super(firstName, lastName);       // call Person constructor
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
    public FacultyType getFacultyType() {return facultyType;}

    /**
     * Returns the Faculty's assigned building, see Building class.
     *
     * @return BuildingType, see class.
     */
    public Building getBuilding() {return building;}

    /**
     * Returns the Faculty's assigned room (office).
     *
     * @return room, int
     */
    public int getRoom() {return room;}


    // TODO: add Faculty fields
    /** faculty type (see FacultyType) */
    FacultyType facultyType;

    /** Assigned building on campus (see Building) */
    Building building;

    /** Assigned room on campus */
    int room;

    /** Seattle U email*/
    String email;
}
