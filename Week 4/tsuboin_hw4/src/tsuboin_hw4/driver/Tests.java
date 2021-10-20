package tsuboin_hw4.driver;
import org.junit.Test;
import tsuboin_hw4.enums.*;
import tsuboin_hw4.exception.DuplicateCourseException;
import tsuboin_hw4.exception.DuplicatePersonException;
import tsuboin_hw4.person.Faculty;
import tsuboin_hw4.person.Person;
import tsuboin_hw4.person.Student;
import tsuboin_hw4.registration.Course;
import tsuboin_hw4.registration.Section;
import tsuboin_hw4.system.RegistrationSystem;
import java.time.temporal.TemporalField;

import java.sql.SQLOutput;
import java.time.Year;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * Class description
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */

public class Tests {
	// Arrange


	@Test
	public void testPerson() {
		System.out.println("**** TEST PERSON CLASS ****");
		System.out.println("Created Person Narissa Tsuboi");
		Person Narissa = new Person("Narissa", "Tsuboi");
		System.out.println("Get first name... " + Narissa.getFirstName());
		System.out.println("Get last name... " + Narissa.getLastName());
		System.out.println("Get suid..." + Narissa.getSuid());
		System.out.println("Get Person status..." + Narissa.getStatus());
	}

	@Test
	public void testStudent() {
		System.out.println("**** TEST STUDENT CLASS ****");
		System.out.println("Created student UNDERGRAD Student Francis Kogge");
		Student Francis = new Student("Francis", "Kogge",
			StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.FQ, 2017);
		System.out.println("Get first name... " + Francis.getFirstName());
		System.out.println("Get last name... " + Francis.getLastName());
		System.out.println("Get suid..." + Francis.getSuid());
		System.out.println("Get Person status..." + Francis.getStatus());
		System.out.println("Get student type... " + Francis.getStudentType());
		System.out.println("Get program... " + Francis.getProgram());
		System.out.println("Get year... " + Francis.getStudentYear());
		System.out.println("Get start term... " + Francis.getStartTerm());
		System.out.println();
		System.out.println("Created student GRAD Student Joanna Mendoza");
		Student Joanna = new Student("Joanna", "Mendoza",
			StudentType.GRAD, StudentProgram.MSCS, Quarter.FQ, 2018);
		System.out.println("Get first name... " + Joanna.getFirstName());
		System.out.println("Get last name... " + Joanna.getLastName());
		System.out.println("Get suid..." + Joanna.getSuid());
		System.out.println("Get Person status..." + Joanna.getStatus());
		System.out.println("Get student type... " + Joanna.getStudentType());
		System.out.println("Get program... " + Joanna.getProgram());
		System.out.println("Get year... " + Joanna.getStudentYear());
		System.out.println("Get start term... " + Joanna.getStartTerm());
	}

	@Test
	public void testFaculty() {
		System.out.println("**** TEST FACULTY CLASS ****");
		System.out.println("Created Faculty Momo Haney");
		Faculty Momo = new Faculty("Momo", "Haney",
			FacultyType.PROF, Building.ENGR, 511,
			"haneym@seattleu.edu");
		System.out.println("*** Test superclass methods... ***");
		System.out.println("First name... " + Momo.getFirstName());
		System.out.println("Get last name... " + Momo.getLastName());
		System.out.println("Get suid... " + Momo.getSuid());

		System.out.println("*** Test class methods ***");
		System.out.println("Get FacultyType... " + Momo.getFacultyType());
		System.out.println("Get Building..." + Momo.getBuilding());
		System.out.println("Get room... " + Momo.getRoom());
		System.out.println("Get status... " + Momo.getStatus());
		System.out.println("Test toString()...");
		StringBuilder sb = new StringBuilder();
		System.out.println(Momo.toString(sb));
	}

	@Test
	public void testCourse() {
		/*
		 * Course: Name=CPSC-2600: Foundations of Computer Science,
		 * Credits=5, Prerequisites=[Name=CPSC-1430: Programming and Problem Solving II]
		 */
		System.out.println("**** TEST COURSE CLASS ****");
		System.out.println("Created CPSC-2600 Foundations of Computer Science");
		System.out.println("Added prerequisite CPSC-1000 Computer Basics");
		Course Foundations = new Course(SubjectCode.CPSC, 102, "Object " +
			"Oriented for Dummies",	5);
		System.out.println("Get course code... " + Foundations.getCourseCode());
		System.out.println("Get course number... " + Foundations.getCourseNum());
		System.out.println("Get course name... " + Foundations.getCourseName());
		System.out.println("Get credits... " + Foundations.getCreditNum());
		System.out.println("Get prereqs and display... ");
		Map<SubjectCode, Integer> prs = Foundations.getPrerequisites();

	}

	@Test
	public void testSection() {
		Course Foundations = new Course(SubjectCode.CPSC, 2600,
			"Foundations of Computer Science", 5);
		Faculty Momo = new Faculty("Momo", "Haney",
			FacultyType.PROF, Building.ENGR, 511,
			"haneym@seattleu.edu");

		System.out.println("**** TEST SECTION CLASS ****");
		System.out.println("Created Section 1 of CPSC-2600");
		Section s = new Section(Foundations, 1, Momo, Quarter.RQ, 2019,10,
			Building.ENGR, 101);
		System.out.println("Get section course tag... " + s.getSectionCourse());
		System.out.println("Get section number... " + s.getSection());
		System.out.println("Get instructor... " + s.getSectionInstructor());
		System.out.println("Get term... " + s.getSectionTerm());
		System.out.println("Get capacity... " + s.getSectionCapacity());
		System.out.println("Get location... " + s.getSectionLocation());
	}

	@Test
	public void testSomething() {
		int year = 2018;
		int now = Year.now().getValue();
		int yearsSoFar = year - now;
		System.out.println("year: " + year);
		System.out.println("now: " + now);
		System.out.println("yearSoFar: " + yearsSoFar);
	}
}
