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
public class Faculty {

    /**
     * Overloaded constructor instantiates Faculty object with firstName and
     * lastName.
     *
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     */
    public Faculty(String firstName, String lastName) {
        
        // TODO: implement Faculty constructor
        this.firstName = firstName;
        this.lastName = lastName;

        this.SUID = SUID
    
    }
    
    
    // TODO: add Faculty fields
    /** Faculty member's first name */
    String firstName;
    /** Faculty member's last name */
    String lastName;
    /** Seattle U Identification Number */
    int SUID;
    /** status (see PersonStatus) */
    PersonStatus status;
    /** faculty type (see FacultyType) */
    FacultyType facultyType;
    /** Assigned office on campus (see Building) */
    Building office;
    /** Seattle U email*/
    String email;
}
