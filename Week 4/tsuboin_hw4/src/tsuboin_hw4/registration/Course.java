package tsuboin_hw4.registration;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import tsuboin_hw4.enums.SubjectCode;

import java.util.HashMap;
import java.util.Map;

/**
 * The Course class holds information about a course.
 * subject code:     subject code of the course (see SubjectCode enum)
 * course number:    course number
 * course name:      course name
 * credit number:    number of credits associated with the course
 * prerequisites:    courses that are prerequisites of this course;
 * may have multiple or none
 * For example, CPSC 5011: Object-Oriented Concepts
 * subject code:     CPSC
 * course number:    5011
 * course name:      Object-Oriented Concepts
 * credit number:    3
 * prerequisite(s):  CPSC 5003
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Course {
	/**
	 * The Course overloaded constructor instantiates a new course
	 * with code, course number, name, and the number of credits the
	 * course is worth.
	 *
	 * @param code      The subject code of the course
	 * @param courseNum The course number of the course
	 * @param name      The course name
	 * @param creditNum The number of the credits of the course
	 */
	public Course(SubjectCode code, int courseNum, String name, int creditNum) {
		this.code = code;
		this.courseNum = courseNum;
		this.courseName = name;
		this.creditNum = creditNum;
		this.prerequisites = new HashMap<>();
	}

	/* Getters */

	/**
	 * Returns the course code.
	 *
	 * @return code, see SubjectCode enum class.
	 */
	public SubjectCode getCourseCode() {
		return this.code;
	}

	/**
	 * Returns the course number.
	 *
	 * @return courseNum.
	 */
	public int getCourseNum() {
		return this.courseNum;
	}

	/**
	 * Returns the course name.
	 *
	 * @return courseName
	 */
	public String getCourseName() {
		return this.courseName;
	}

	/**
	 * Returns the credits the course is worth.
	 *
	 * @return creditNum
	 */
	public int getCreditNum() {
		return this.creditNum;
	}

	/**
	 * Returns a treemap of prerequisites.
	 *
	 * @return prerequisites, {SubjectCode-CourseNum: CourseName}
	 */
	public Map<SubjectCode, Integer> getPrerequisites() {
		return this.prerequisites;
	}

	/* Setters */

	/**
	 * Add a prerequisites course's code and name to another course's
	 * prerequisite collection.
	 *
	 * @param code      subject code of the course (see SubjectCode enum)
	 * @param courseNum course number
	 */
	public void setPrerequisite(SubjectCode code, int courseNum) {
		prerequisites.put(code, courseNum);
	}

	/* Utility */

	/**
	 * toString for Course objects.
	 *
	 * @return string representation of Course object.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name=").append(this.code).append("-").append(this.courseNum);
		sb.append(": ").append(this.courseName);
		sb.append(", ");
		sb.append("Credits=").append(this.creditNum);
		sb.append(", ");
		return sb.toString();
	}

	/* Private Fields*/
	/**
	 * subject code (see SubjectCode)
	 */
	private final SubjectCode code;

	/**
	 * course number
	 */
	private final int courseNum;

	/**
	 * course name
	 */
	private final String courseName;

	/**
	 * credit number
	 */
	private final int creditNum;

	/**
	 * a collection of prerequisite course(s)
	 */
	private final Map<SubjectCode, Integer> prerequisites;
}

