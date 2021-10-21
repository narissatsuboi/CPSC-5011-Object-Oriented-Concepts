package tsuboin_hw4.driver;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.*;
import tsuboin_hw4.exception.*;
import tsuboin_hw4.person.Faculty;
import tsuboin_hw4.person.Student;
import tsuboin_hw4.registration.Course;
import tsuboin_hw4.registration.Section;
import tsuboin_hw4.system.RegistrationSystem;

import java.util.Map;


/**
 * The Driver interfaces with the registration system and populates faculty,
 * students, subjects, courses, their prerequisites, and course sections.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Driver {

	public static void main(String[] args) {
		RegistrationSystem system = new RegistrationSystem();
		populateSystem(system);

		// Print the results of the RegistrationSystem collections
		// this includes all the contents of: faculty, students, subjects,
		// courses (and their prerequisites), and course section; additional
		// functions may be added to the System to complete this task
		printSystem(system);
	}

	private static void populateSystem(RegistrationSystem system) {
		try {
			populateFaculty(system);
			populateStudents(system);
			populateSubjects(system);
			populateCourses(system);
			populatePrerequisites(system);
			populateSections(system);
		} catch (DuplicatePersonException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateSubjectException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateCourseException e) {
			System.out.println(e.getMessage());
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateSectionException e) {
			System.out.println(e.getMessage());
		} catch (SectionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void populateStudents(RegistrationSystem system)
		throws DuplicatePersonException {
		system.addStudent("Michael", "Bluth", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.FQ, 2018);
		system.addStudent("Gob", "Bluth", StudentType.UNDERGRAD, StudentProgram.BACS, Quarter.SQ, 2018);
		system.addStudent("Buster", "Bluth", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.WQ, 2018);
		system.addStudent("Lucille", "Bluth", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.WQ, 2017);
		system.addStudent("Lindsay", "Funke", StudentType.UNDERGRAD, StudentProgram.BACS, Quarter.FQ, 2018);
		system.addStudent("Tobias", "Funke", StudentType.UNDERGRAD, StudentProgram.BACS, Quarter.FQ, 2017);
		system.addStudent("Maeby", "Funke", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.SQ, 2017);
		system.addStudent("Kitty", "Sanchez", StudentType.UNDERGRAD, StudentProgram.UNDECIDED, Quarter.FQ, 2018);
		system.addStudent("Edsger", "Dijkstra", StudentType.GRAD, StudentProgram.CERT, Quarter.RQ, 2018);
		system.addStudent("Ada", "Lovelace", StudentType.GRAD, StudentProgram.CERT, Quarter.FQ, 2018);
		system.addStudent("Grace", "Hopper", StudentType.GRAD, StudentProgram.MSCS, Quarter.WQ, 2017);
		system.addStudent("Marie", "Curie", StudentType.GRAD, StudentProgram.CERT, Quarter.FQ, 2017);
		system.addStudent("Alan", "Turing", StudentType.GRAD, StudentProgram.CERT, Quarter.RQ, 2017);
		system.addStudent("Katherine", "Johnson", StudentType.GRAD, StudentProgram.MSCS, Quarter.FQ, 2018);
	}

	private static void populateFaculty(RegistrationSystem system)
		throws DuplicatePersonException {
		system.addFaculty("Adair", "Dingle", FacultyType.PROF, Building.ENGR, 531, "dingle@seattleu.edu");
		system.addFaculty("Steven", "Hanks", FacultyType.LECTURE, Building.ENGR, 511, "hankssteven@seattleu.edu");
		system.addFaculty("Pejman", "Khadivi", FacultyType.ASSTPROF, Building.ENGR, 521, "khadivip@seattleu.edu");
		system.addFaculty("Michael", "Koenig", FacultyType.LECTURE, Building.ENGR, 520, "koenigm@seattleu.edu");
		system.addFaculty("Eric", "Larson", FacultyType.PROF, Building.ENGR, 528, "elarson@seattleu.edu");
		system.addFaculty("Richard", "LeBlanc", FacultyType.PROF, Building.ENGR, 527, "leblanc@seattleu.edu");
		system.addFaculty("Lin", "Li", FacultyType.ASSTPROF, Building.ENGR, 529, "lil@seattleu.edu");
		system.addFaculty("David", "Lillethun", FacultyType.ASSTPROF, Building.ENGR, 506, "lillethd@seattleu.edu");
		system.addFaculty("Kevin", "Lundeen", FacultyType.INSTRUCT, Building.ENGR, 519, "lundeenk@seattleu.edu");
		system.addFaculty("Michael", "McKee", FacultyType.LECTURE, Building.ENGR, 519, "mckeem@seattleu.edu");
		system.addFaculty("Aditya", "Mishra", FacultyType.ASSTPROF, Building.ENGR, 507, "mishraa@seattleu.edu");
		system.addFaculty("James", "Obare", FacultyType.INSTRUCT, Building.ENGR, 502, "obarej@seattleu.edu");
		system.addFaculty("Sheila", "Oh", FacultyType.SEN_INSTRUCT, Building.ENGR, 504, "ohsh@seattleu.edu");
		system.addFaculty("Susan", "Reeder", FacultyType.SEN_INSTRUCT, Building.ENGR, 505, "sreeder@seattleu.edu");
		system.addFaculty("Roshanak", "Roshandel", FacultyType.ASSOCPROF, Building.ENGR, 508, "roshanak@seattleu.edu");
		system.addFaculty("Jason", "Wong", FacultyType.INSTRUCT, Building.ENGR, 526, "wongja@seattleu.edu");
		system.addFaculty("Yingwu", "Zhu", FacultyType.ASSOCPROF, Building.ENGR, 530, "zhuy@seattleu.edu");
	}

	private static void populateSubjects(RegistrationSystem system)
		throws DuplicateSubjectException {
		system.addSubject(SubjectCode.BIOL, "Biology");
		system.addSubject(SubjectCode.CHEM, "Chemistry");
		system.addSubject(SubjectCode.CPSC, "Computer Science");
		system.addSubject(SubjectCode.MATH, "Mathematics");
	}

	private static void populateCourses(RegistrationSystem system)
		throws DuplicateCourseException {
		system.addCourse(SubjectCode.CPSC, 1420, "Programming and Problem Solving I", 5);
		system.addCourse(SubjectCode.CPSC, 1430, "Programming and Problem Solving II", 5);
		system.addCourse(SubjectCode.CPSC, 2430, "Data Structures", 5);
		system.addCourse(SubjectCode.CPSC, 2500, "Computer Organization", 5);
		system.addCourse(SubjectCode.CPSC, 2600, "Foundations of Computer Science", 5);
		system.addCourse(SubjectCode.CPSC, 3200, "Object-Oriented Development", 5);
		system.addCourse(SubjectCode.CPSC, 3300, "Fundamentals of Databases", 5);
		system.addCourse(SubjectCode.CPSC, 3400, "Languages and Computation", 5);
		system.addCourse(SubjectCode.CPSC, 3500, "Computing Systems", 5);
		system.addCourse(SubjectCode.CPSC, 4100, "Design and Analysis of Algorithms", 5);
		system.addCourse(SubjectCode.CPSC, 5001, "Programming Boot Camp I", 3);
		system.addCourse(SubjectCode.CPSC, 5002, "Programming Boot Camp II", 3);
		system.addCourse(SubjectCode.CPSC, 5003, "Programming Boot Camp III", 3);
		system.addCourse(SubjectCode.CPSC, 5011, "Object-Oriented Concepts", 3);
		system.addCourse(SubjectCode.CPSC, 5021, "Database Systems", 3);
		system.addCourse(SubjectCode.CPSC, 5031, "Data Structures and Algorithms", 3);
		system.addCourse(SubjectCode.CPSC, 5041, "Computing Systems Principles I", 3);
		system.addCourse(SubjectCode.CPSC, 5042, "Computing Systems Principles II", 3);
		system.addCourse(SubjectCode.CPSC, 5051, "Fundamentals of Software Engineering", 3);
		system.addCourse(SubjectCode.CPSC, 5200, "Software Architecture and Design", 5);
		system.addCourse(SubjectCode.CPSC, 5800, "Ethics and Professional Issues in Computing", 2);
		system.addCourse(SubjectCode.CPSC, 5600, "Parallel Computing", 5);
		system.addCourse(SubjectCode.CPSC, 5610, "Artificial Intelligence", 5);
		system.addCourse(SubjectCode.CPSC, 5510, "Computer Networks", 5);
		system.addCourse(SubjectCode.CPSC, 5520, "Distributed Systems", 5);
		system.addCourse(SubjectCode.CPSC, 5240, "Software as a Service", 5);
		system.addCourse(SubjectCode.CPSC, 5250, "Mobile Software Development", 5);
		system.addCourse(SubjectCode.CPSC, 5300, "Physical Database Design & Optimization", 5);
		system.addCourse(SubjectCode.CPSC, 5400, "Complier Principles and Techniques", 5);
		system.addCourse(SubjectCode.CPSC, 5700, "Computer Graphics", 5);
	}

	private static void populatePrerequisites(RegistrationSystem system)
		throws CourseNotFoundException {
		system.addPrerequisite(SubjectCode.CPSC, 1430, SubjectCode.CPSC, 1420);
		system.addPrerequisite(SubjectCode.CPSC, 2430, SubjectCode.CPSC, 1430);
		system.addPrerequisite(SubjectCode.CPSC, 2500, SubjectCode.CPSC, 1430);
		system.addPrerequisite(SubjectCode.CPSC, 2600, SubjectCode.CPSC, 1430);
		system.addPrerequisite(SubjectCode.CPSC, 3200, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3300, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3400, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3400, SubjectCode.CPSC, 2600);
		system.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2500);
		system.addPrerequisite(SubjectCode.CPSC, 4100, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 4100, SubjectCode.CPSC, 2600);
		system.addPrerequisite(SubjectCode.CPSC, 5002, SubjectCode.CPSC, 5001);
		system.addPrerequisite(SubjectCode.CPSC, 5003, SubjectCode.CPSC, 5002);
		system.addPrerequisite(SubjectCode.CPSC, 5011, SubjectCode.CPSC, 5003);
		system.addPrerequisite(SubjectCode.CPSC, 5021, SubjectCode.CPSC, 5003);
		system.addPrerequisite(SubjectCode.CPSC, 5042, SubjectCode.CPSC, 5041);
		system.addPrerequisite(SubjectCode.CPSC, 5200, SubjectCode.CPSC, 5011);
		system.addPrerequisite(SubjectCode.CPSC, 5200, SubjectCode.CPSC, 5051);
		system.addPrerequisite(SubjectCode.CPSC, 5600, SubjectCode.CPSC, 5031);
		system.addPrerequisite(SubjectCode.CPSC, 5600, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5610, SubjectCode.CPSC, 5031);
		system.addPrerequisite(SubjectCode.CPSC, 5510, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5520, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5240, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5250, SubjectCode.CPSC, 5011);
		system.addPrerequisite(SubjectCode.CPSC, 5300, SubjectCode.CPSC, 5021);
		system.addPrerequisite(SubjectCode.CPSC, 5700, SubjectCode.CPSC, 5031);
	}

	private static void populateSections(RegistrationSystem system)
		throws CourseNotFoundException, PersonNotFoundException,
		DuplicateSectionException, SectionNotFoundException {
		system.addSection(SubjectCode.CPSC, 2430, 1, "Susan", "Reeder", Quarter.FQ, 2018, 15, Building.PIGT, 207);
		system.addSection(SubjectCode.CPSC, 2430, 2, "Adair", "Dingle", Quarter.FQ, 2018, 30, Building.PIGT, 207);
		system.addSection(SubjectCode.CPSC, 2600, 1, "Sheila", "Oh", Quarter.FQ, 2018, 30, Building.LEML, 122);
		system.addSection(SubjectCode.CPSC, 4100, 1, "Yingwu", "Zhu", Quarter.FQ, 2018, 34, Building.PIGT, 102);
		system.addSection(SubjectCode.CPSC, 5011, 1, "Steven", "Hanks", Quarter.FQ, 2018, 20, Building.ADMN, 203);
		system.addSection(SubjectCode.CPSC, 5011, 2, "Sheila", "Oh", Quarter.FQ, 2018, 30, Building.LEML, 122);
		system.addSection(SubjectCode.CPSC, 5021, 1, "Michael", "McKee", Quarter.FQ, 2018, 36, Building.BANN, 401);
		system.addSection(SubjectCode.CPSC, 5021, 2, "Michael", "McKee", Quarter.FQ, 2018, 30, Building.LEML, 122);
		system.addSection(SubjectCode.CPSC, 5510, 1, "David", "Lillethun", Quarter.FQ, 2018, 30, Building.ENGR, 304);
		system.addSection(SubjectCode.CPSC, 5600, 2, "Kevin", "Lundeen", Quarter.FQ, 2018, 20, Building.BANN, 402);
	}

	/**
	 * Displays a formatted list of Faculty, Student, Subject, Course,
	 * and Section data stored in the RegistrationSystem.
	 *
	 * @param system RegistrationSystem.
	 */
	private static void printSystem(RegistrationSystem system) {
		System.out.println("-- FACULTY LIST --");
		printFaculty(system);

		System.out.println("\n-- STUDENT LIST --");
		printStudents(system);

		System.out.println("\n-- SUBJECT LIST --");
		printSubjects(system);

		System.out.println("\n-- COURSE LIST --");
		printCourses(system);

		System.out.println("\n-- SECTION LIST --");
		printSections(system);
	}

	/* printSystem Helper Methods */

	/**
	 * Displays a list of Faculty stored in the registration system.
	 *
	 * @param system RegistrationSystem.
	 */
	private static void printFaculty(RegistrationSystem system) {
		Map<String, Faculty> faculty = system.getFaculty();
		StringBuilder sb = new StringBuilder();

		for (Faculty entry : faculty.values()) {
			System.out.print("Faculty: ");
			System.out.println(entry.toString(sb));
			sb.setLength(0);
		}
	}

	/**
	 * Displays the current list of students stored in the registration
	 * system.
	 *
	 * @param system Registration System
	 */
	private static void printStudents(RegistrationSystem system) {
		Map<String, Student> students = system.getStudents();
		StringBuilder sb = new StringBuilder();
		for (Student entry : students.values()) {
			System.out.print("Student: ");
			System.out.println(entry.toString(sb));
			sb.setLength(0);
		}
	}

	/**
	 * Displays a list of subjects and their abbreviations.
	 *
	 * @param system RegistrationSystem
	 */
	private static void printSubjects(RegistrationSystem system) {
		Map<SubjectCode, String> subjects = system.getSubjects();
		for (Map.Entry<SubjectCode, String> entry : subjects.entrySet()) {
			System.out.print("Subject: ");
			System.out.print(entry.getValue());
			System.out.print(" (" + entry.getKey() + ")\n");
		}
	}

	/**
	 * Displays formatted list of courses and their fields.
	 *
	 * @param system RegistrationSystem
	 */
	private static void printCourses(RegistrationSystem system) {
		Map<String, Course> courses = system.getCourses();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (Course entry : courses.values()) {
			System.out.print("Course: ");
			System.out.print(entry.toString(sb1));
			// Prereqs
			System.out.print("Prerequisites=");
			System.out.println(system.prerequisitesToString(entry, sb2));
			sb1.setLength(0);
			sb2.setLength(0);
		}
	}

	/**
	 * Displays formatted list of course sections and their fields.
	 *
	 * @param system RegistrationSystem
	 */
	private static void printSections(RegistrationSystem system) {
		Map<String, Section> sections = system.getSections();
		String courseTag, sectionNum, courseName, facName, term, room, capacity;
		StringBuilder sb = new StringBuilder();
		for (Section sec : sections.values()) {
			courseTag = sec.getSectionCourse();
			sectionNum = sec.getSection();
			courseName = system.getCourses().get(courseTag).getCourseName();

			sb.append("Section: Course=");
			// CPSC-3400-01
			sb.append(sec.getSectionCourse() + "-").append(sec.getSection() + ": ");
			sb.append(system.getCourses().get(sec.getSectionCourse()).getCourseName());
			sb.append(", ");
			sb.append("Faculty=").append(sec.getSectionInstructor());
			sb.append(", ");
			sb.append("Term=").append(sec.getSectionTerm());
			sb.append(", ");
			sb.append("Capacity=").append(sec.getSectionCapacity());
			sb.append(", ");
			sb.append("Location=").append(sec.getSectionLocation());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

