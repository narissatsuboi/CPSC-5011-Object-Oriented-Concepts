package tsuboin_hw4.registration;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.Building;
import tsuboin_hw4.enums.Quarter;
import tsuboin_hw4.person.Faculty;


/**
 * The Section class holds information about a course section.
 *
 * course:          course associated with the section
 * section:         section number for the course
 * instructor:      instructor for the section (assume single instructor)
 * term:            quarter and year when the section is offered
 * capacity:        capacity for the section
 * location:        building and room where the section is held (see
 *                  Building enum)
 * For example, CPSC-5011-02: Object-Oriented Concepts
 * course:          CPSC-5011
 * section:         02
 * instructor:      Sheila Oh
 * term (quarter/year):FQ18
 * capacity:        30
 * location (building/room): LEML 122
 *
 * @author Narissa Tsuboi
 */
public class Section {    
    
    /**
     * Overloaded Section constructor instantiates all section fields
     * for a given course.
     *
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor, Quarter quarter, 
                    int year, int cap, Building bldg, int room) {
        this.course =
            course.getCourseCode().toString() + "-" + course.getCourseNum();
        this.section = "0" + Integer.toString(section);
        this.instructor =
            instructor.getFirstName() + " " + instructor.getLastName();
        this.term = quarter.name() + " " + year;
        this.capacity = cap;
        this.location = bldg.name() + " " + room;
    }

    /* Getters */
    /**
     * Returns the course (SubjectCode + course number).
     * @return course, ie CPSC-2630.
     */
    public String getSectionCourse() {return this.course;}

    /**
     * Returns the section number.
     * @return section.
     */
    public String getSection() {return this.section;}

    /**
     * Returns the instructor assigned to teach this section.
     * @return instructor first and last name.
     */
    public String getSectionInstructor() {return this.instructor;}

    /**
     * Returns the section term.
     * @return term.
     */
    public String getSectionTerm() {return this.term;}

    /**
     * Returns the section capacity, no maximum set by default.
     * @return capacity.
     */
    public int getSectionCapacity() {return this.capacity;}

    /**
     * Returns the section's location for class meetings.
     * @return location, ie ENGR 101.
     */
    public String getSectionLocation() {return this.location;}

    /* Private Fields */
    /** course */
    private String course;

    /** section */
    private String section;

    /** instructor*/
    private String instructor;

    /** term (see Quarter)*/
    private String term;

    /** capacity */
    private int capacity;

    /** location (see Building)*/
    private String location;
}
