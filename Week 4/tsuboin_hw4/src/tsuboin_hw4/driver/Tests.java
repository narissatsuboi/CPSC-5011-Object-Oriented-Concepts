package tsuboin_hw4.driver;
import org.junit.Test;
import tsuboin_hw4.enums.*;
import tsuboin_hw4.person.Faculty;
import tsuboin_hw4.person.Person;
import tsuboin_hw4.person.Student;
import tsuboin_hw4.registration.Course;
import tsuboin_hw4.system.RegistrationSystem;
import java.time.temporal.TemporalField;

import java.sql.SQLOutput;
import java.time.Year;
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
		System.out.println("Get Person key..." + Momo.getPersonKey());

		System.out.println("*** Test class methods ***");
		System.out.println("Get FacultyType... " + Momo.getFacultyType());
		System.out.println("Get Building..." + Momo.getBuilding());
		System.out.println("Get room... " + Momo.getRoom());
		System.out.println("Get status... " + Momo.getStatus());
	}

	@Test
	public void testCourse() {
		/**
		 * Course: Name=CPSC-2600: Foundations of Computer Science,
		 * Credits=5, Prerequisites=[Name=CPSC-1430: Programming and Problem Solving II]
		 */
		System.out.println("**** TEST COURSE CLASS ****");
		System.out.println("Created CPSC-2600 Foundations of Computer Science");
		System.out.println("Added prerequisite CPSC-1000 Computer Basics");
		Course Foundations = new Course(SubjectCode.CPSC, 2600, "Foundations " +
			"of Computer Science", 5);
		Foundations.setPrerequisite(SubjectCode.CPSC, 1000,
			"Computer Basics");
		System.out.println("Get course code... " + Foundations.getCourseCode());
		System.out.println("Get course number... " + Foundations.getCourseNum());
		System.out.println("Get course name... " + Foundations.getCourseName());
		System.out.println("Get credits... " + Foundations.getCreditNum());
		System.out.println("Get prereqs and display... ");
		Map<String, String> prs = Foundations.getPrerequisites();
		for (Map.Entry<String, String> entry : prs.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.printf("%s : %s\n", key, value);
		}
	}

	@Test
	public void testRegistrationSystem() {
		// Arrange
		RegistrationSystem rs = new RegistrationSystem();

		Faculty Momo = new Faculty("Momo", "Haney", FacultyType.PROF,
			Building.ENGR, 511, "haneym@seattleu.edu");
	}
	// Test Faculty was added to facultyList

}
