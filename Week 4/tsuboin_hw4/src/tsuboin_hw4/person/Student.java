package tsuboin_hw4.person;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.*;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.time.Year;

/**
 * The Student class holds information about a student. First name,
 * last name, suid, and status are handled by superclass Person.
 *
 * student type:          a student can only be assigned a single
 *                        student type (see StudentType enum)
 * student program:       a student can only be assigned to a single
 *                        program at a point of time, but can switch
 *                        from one program to another (i.e. when
 *                        they've graduated from a program (see
 *                        StudentProgram enum)
 * student year:          only relevant for undergraduates (see
 *                        StudentYear enum)
 * start term:            associated with the quarter and year a
 *                        student starts a particular program; for
 *                        example, a single student may start the CERT
 *                        in RQ17 and then continue the MSCS in FQ18
 *                        (see Quarter enum)
 * faculty advisor:       students are randomly assigned a faculty
 *                        advisor, but may switch advisors
 *                        (i.e. faculty leaves or on sabbatical); may
 *                        not be assigned an advisor for a period of
 *                        time when first enrolled as a student
 * email:                 the school (i.e. SU) email address
 *
 * For example, student Ada Lovelace
 * first name:            Ada
 * last name:             Lovelace
 * suid:                  100027
 * status:                ACTIVE
 * student type:          GRAD
 * student program:       CERT
 * student year:          JUNIOR
 * start term:            FQ 2018
 * faculty advisor:       Lin Li
 * email:                 adalovelace@seattleu.edu

 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Student extends Person {


    /**
     * Overloaded Student constructor instantiates a new Student
     * object and initializes all class fields. Inherits firstName,
     * lastName, suid, and status getters from Person class.
     *
     * @param firstName  first name of the student
     * @param lastName   last name of the student
     * @param type       see StudentType enum
     * @param program    see StudentProgram enum
     * @param startTerm  see Quarter enum
     * @param year       year Student started at the university
     */
    public Student(String firstName, String lastName, StudentType type,
                   StudentProgram program, Quarter startTerm, int year) {
        super(firstName, lastName);          // Superclass Person
        this.studentType = type;
        this.program = program;

        // Assign a StudentYear to UNDERGRADUATES only
        if (studentType == StudentType.UNDERGRAD)
            this.studentYear = calculateStudentYear(year);
        else
            this.studentYear = null;
        this.startTerm = startTerm;
        this.email = makeEmail();
    }

    /* Getters */

    /**
     * Returns the Student's student type.
     * @return studentType, see StudentType enum class.
     */
    public StudentType getStudentType() {return this.studentType;}

    /**
     * Returns the Student's current program.
     * @return program, see StudentProgram enum class.
     */
    public StudentProgram getProgram() {return this.program;}

    /**
     * Returns the Student's year if Student has StudentType UNDERGRAD.
     * @return studentYear, see StudentYear enum class.
     */
    public StudentYear getStudentYear() {return this.studentYear;}

    /**
     * Returns the Student's start term.
     * @return startTerm, see Quarter enum class.
     */
    public Quarter getStartTerm() {return this.startTerm;}

    // TODO Advisor GETTER Student class

    /**
     * Returns the Student's email address.
     * @return email
     */
    public String getEmail() {return this.email;}

    /*
     ****************************************************************
     * Setters
     * Student setters are available to update Student fields after
     * object instantiation.
     * Example use cases:
     *    A student has gone from undergraduate to a graduate program.
     *    A student is now a JUNIOR instead of a SOPHOMORE.
     */

    /**
     * Change a student's type from undergraduate to graduate or visa-
     * versa if they move onto another program.
     *
     * @param type See StudentType enum class.
     */
     public void setStudentType(StudentType type) {this.studentType = type;}

    /**
     * Change a student's academic program to a different program
     * from the StudentProgram enum class. IE, a student graduates
     * from the certificate program to the MSCS.
     *
     * @param program A program from the StudentProgram class.
     */
    public void setStudentProgram(StudentProgram program) {this.program =
        program;}

    /**
     * Change an undergraduate student's academic year manually as they
     * advance.
     *
     * @param year StudentYear FRESHMAN, SOPHMORE, etc.
     */
    public void setStudentYear(StudentYear year) {this.studentYear = year;}


    /*
     * Private Methods and Fields
     */

    /**
     * Generates Student Seattle U email.
     *
     * @return email, firstlast@seattleu.edu
     */
    private String makeEmail() {
        final String DOMAIN = "@seattleu.edu";
        return this.firstName + this.lastName + DOMAIN;
    }

    /**
     * Calculates the StudentYear of a student based on their start year,
     * assumes 4 year degree for undergraduates, and the following quarter
     * breakdown: Months 1 - 3, FQ
     *                   4 - 6, SQ
     *                   7 - 9, RQ
     *                   10 -12, QQ
     *
     * @param year ie 2017, 2020
     * @return FRESHMAN, SOPHMORE, etc
     */
    private StudentYear calculateStudentYear(int year) {
        StudentYear studentYear = StudentYear.FRESHMAN;
        final int SENIOR = 4;
        final int JUNIOR = 3;
        final int SOPH = 2;
        final int FRESH = 1;

        // Determine current quarter
        Quarter nowQuarter;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH);
        if (month >= 1 && month <= 3)
            nowQuarter = Quarter.WQ;
        else if (month >= 4 && month <= 6)
            nowQuarter = Quarter.SQ;
        else if (month >=7 && month <= 9)
            nowQuarter = Quarter.RQ;
        else if (month >= 10)
            nowQuarter = Quarter.FQ;

        // Determine years since start
        int now = Year.now().getValue();
        int yearsSoFar = year - now;

        // Determine StudentYear
        if ((yearsSoFar == SENIOR)
            || (this.startTerm == Quarter.FQ && yearsSoFar == JUNIOR))
            studentYear = StudentYear.SENIOR;
        else if ((yearsSoFar == JUNIOR)
            || (this.startTerm == Quarter.FQ) && yearsSoFar == SOPH)
            studentYear = StudentYear.JUNIOR;
        else if ((yearsSoFar == SOPH)
            || (this.startTerm == Quarter.FQ) && yearsSoFar == FRESH)
            studentYear = StudentYear.SOPHOMORE;

        return studentYear;
    }

    /** student type (see StudentType)*/
    StudentType studentType;

    /** student program (see StudentProgram)*/
    StudentProgram program;

    /** student year (see StudentYear; only if undergrad––default to
     * freshman) */
    StudentYear studentYear;

    /** startTerm (see Quarter)*/
    Quarter startTerm;

    /** Faculty advisor, randomly assigned*/
    // TODO: Faculty advisor in student class
    Faculty facultyAdvisor;

    /** Seattle U email*/
    String email;

}
