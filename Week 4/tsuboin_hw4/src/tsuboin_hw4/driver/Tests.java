package tsuboin_hw4.driver;

import org.junit.Test;
import tsuboin_hw4.enums.*;
import tsuboin_hw4.exception.CourseNotFoundException;
import tsuboin_hw4.exception.DuplicateCourseException;
import tsuboin_hw4.person.Faculty;
import tsuboin_hw4.person.Person;
import tsuboin_hw4.person.Student;
import tsuboin_hw4.registration.Course;
import tsuboin_hw4.registration.Section;
import tsuboin_hw4.system.RegistrationSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
	// Arrange and populate test Registration System
	RegistrationSystem rs = new RegistrationSystem();

	/*
Course: Name=CPSC-3500: Computing Systems, Credits=5,
Prerequisites=[Name=CPSC-2430: Data Structures, Name=CPSC-2500: Computer Organization]
 */
	Course computingSystems = new Course(SubjectCode.CPSC, 3500,
		"Computing Systems", 5);

	// faculty
	Faculty momo = new Faculty("Momo", "Haney",
		FacultyType.PROF, Building.ENGR, 511,
		"haneym@seattleu.edu");

	@Test
	public void testPerson() {
		// person superclass
		Person narissa = new Person("Narissa", "Tsuboi");

		assertEquals("Narissa", narissa.getFirstName());
		assertEquals("Tsuboi", narissa.getLastName());
		assertEquals(PersonStatus.ACTIVE, narissa.getStatus());
	}

	@Test
	public void testStudent() {
		// undergraduate student, senior
		Student francis = new Student("Francis", "Kogge",
			StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.FQ, 2017);
		// graduate student
		Student joanna = new Student("Joanna", "Mendoza",
			StudentType.GRAD, StudentProgram.MSCS, Quarter.FQ, 2018);

		// Test getters for undergraduate student
		assertEquals(StudentType.UNDERGRAD, francis.getStudentType());
		assertEquals(StudentProgram.BSCS, francis.getProgram());
		assertEquals(StudentYear.SENIOR, francis.getStudentYear());
		assertEquals(Quarter.FQ, francis.getStartTerm());

		// Test Student Year is null for a grad student
		assertNull(joanna.getStudentYear());
	}

	@Test
	public void testFaculty() {


		// Test Faculty getters
		assertEquals(FacultyType.PROF, momo.getFacultyType());
		assertEquals(Building.ENGR, momo.getBuilding());
		assertEquals(511, momo.getRoom());
	}

	@Test
	public void testCourse() {

		assertEquals(SubjectCode.CPSC, computingSystems.getCourseCode());
		assertEquals(3500, computingSystems.getCourseNum());
		assertEquals("Computing Systems", computingSystems.getCourseName());
		assertEquals(5, computingSystems.getCreditNum());
	}

	@Test
	public void testSection() {
		Section section = new Section(computingSystems, 1, momo, Quarter.FQ,
			2017, 30, Building.ENGR, 300);
		// test section getters
		assertEquals("CPSC-3500", section.getSectionCourse());
		assertEquals("01", section.getSection());
		assertEquals(momo.getFirstName() + " " + momo.getLastName(),
			section.getSectionInstructor());
		assertEquals("FQ 2017", section.getSectionTerm());
		assertEquals(30, section.getSectionCapacity());
		assertEquals("ENGR 300", section.getSectionLocation());
	}

	@Test
	public void testRegistrationSystem()
		throws DuplicateCourseException, CourseNotFoundException {

		Course cs = new Course(SubjectCode.CPSC, 3500, "Computing Systems", 5);
		rs.addCourse(SubjectCode.CPSC, 3500, "Computing System",
			5);
		rs.addCourse(SubjectCode.CPSC, 2430, "Data " +
			"Structures", 5);
		rs.addCourse(SubjectCode.CPSC, 2500, "Computer " +
			"Organization", 3);

		// add prerequisites
		rs.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2430);
		rs.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2500);

	}

}
