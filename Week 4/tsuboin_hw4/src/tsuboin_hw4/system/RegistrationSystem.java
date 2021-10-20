package tsuboin_hw4.system;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import com.sun.source.tree.Tree;
import tsuboin_hw4.enums.Building;
import tsuboin_hw4.enums.FacultyType;
import tsuboin_hw4.enums.Quarter;
import tsuboin_hw4.enums.StudentType;
import tsuboin_hw4.enums.SubjectCode;
import tsuboin_hw4.enums.StudentProgram;
import tsuboin_hw4.exception.CourseNotFoundException;
import tsuboin_hw4.exception.DuplicateCourseException;
import tsuboin_hw4.exception.DuplicatePersonException;
import tsuboin_hw4.exception.DuplicateSubjectException;
import tsuboin_hw4.exception.PersonNotFoundException;
import tsuboin_hw4.exception.DuplicateSectionException;
import tsuboin_hw4.person.Faculty;
import tsuboin_hw4.person.Student;
import tsuboin_hw4.registration.Course;
import tsuboin_hw4.registration.Section;

import javax.security.auth.Subject;
import java.util.*;

/**
 * The RegistrationSystem class stores information about the school,
 * including the ability to add students, add faculty, add courses,
 * and add prerequisite(s).
 * 
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class RegistrationSystem {
    /**
     * Default RegistrationSystem instantiates RS object and
     * initializes collections for students, faculty, courses,
     * subjects, and sections.
     */
    public RegistrationSystem() { 
        studentMap = new TreeMap<>();
        facultyMap = new TreeMap<>();
        courseMap = new TreeMap<>();
        subjectMap = new TreeMap<>();
        sectionMap = new TreeMap<>();
    }

    /* Setters */
    /**
     * Add a student to the student list collection.
     * 
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program    
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName, 
                            StudentType type, StudentProgram program,
                            Quarter quarter, int year) 
                            throws DuplicatePersonException {
        // key to studentMap
        String key = firstName + lastName;

        // Check if student already exists in studentMap
        if (studentMap.containsKey(key))
            throw new DuplicatePersonException();
        // Instantiate new student and add to studentMap
        studentMap.put(key, new Student(firstName, lastName, type, program,
            quarter, year));
        // Assign advisor
        assignFacultyAdvisor(studentMap.get(key));
    }
    
    /**
     * Add a faculty to the faculty list collection.
     * 
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                           FacultyType type, Building bldg,
                           int room, String email)
                            throws DuplicatePersonException {
        // key to facultyMap
        String key = firstName + lastName;
        // Check if faculty already exists in facultyMap
        if (facultyMap.containsKey(key))
            throw new DuplicatePersonException();
        // Instantiate new Faculty object and add to facultyMap
        facultyMap.put(key, new Faculty(firstName, lastName,
            type, bldg, room, email));
    }
    
    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     * 
     * @param code    The subject code
     * @param desc    The subject description
     * 
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc) 
                            throws DuplicateSubjectException {

        // Check if code is already in the subjectMap
        if (subjectMap.containsKey(code))
            throw new DuplicateSubjectException();
        // Add new entry to subjectMap
        subjectMap.put(code, desc);
    }
    
    /**
     * Adds a course to the course list collection.
     * 
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system 
     */
    public void addCourse(SubjectCode code, int num, String name, 
                            int creditNum) throws DuplicateCourseException {
        // key to courseMap
        String key = code.name() + "-" + num;
        // Check if course already exists in courseMap
        if (courseMap.containsKey(key))
            throw new DuplicateCourseException();
        // Instantiate new course and add to courseMap
        courseMap.put(key, new Course(code, num, name, creditNum));
    }
    
    /**
     * Adds a prerequisite to an existing course in the course
     * list collection.
     * 
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num, 
                            SubjectCode prereqCode, int prereqNum) 
                            throws CourseNotFoundException {

        String key = code.name() + "-" + num;
        String prereqKey = prereqCode.name() + "-" + prereqNum;
        boolean courseExists = courseMap.containsKey(key);
        boolean prereqCourseExists = courseMap.containsKey(prereqKey);

        // Check that the course and prereq exist
        if (!courseExists || !prereqCourseExists)
            throw new CourseNotFoundException();
        // Access course's prequisites and add
        Course course = courseMap.get(key);
        course.setPrerequisite(prereqCode, prereqNum);
    }
    
    /**
     * Adds a section to the section list collection.
     * 
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum,
                           String firstName, String lastName, Quarter quarter,
                           int year, int cap, Building bldg, int room)
        throws CourseNotFoundException, PersonNotFoundException,
        DuplicateSectionException {

        String courseMapKey =  code.name() + "-" + courseNum;
        String facultyMapKey = firstName + lastName;
        String key = code.name() + "-" + courseMapKey + "0" + sectionNum;
        boolean courseExists = courseMap.containsKey(courseMapKey);
        boolean facultyExists = facultyMap.containsKey(facultyMapKey);

        // Check if course exists and faculty exists
        if (!courseExists)
            throw new CourseNotFoundException();
        if (!facultyExists)
            throw new PersonNotFoundException();
        // Check if section exists
        Course course = courseMap.get(courseMapKey);
        if (course.getPrerequisites().containsKey(key))
            throw new DuplicateSectionException();
        // Add section
        sectionMap.put(key, new Section(courseMap.get(courseMapKey), sectionNum,
            facultyMap.get(firstName+lastName), quarter, year, cap, bldg,
            room));
    }

    /**
     * Returns a random faculty member from the facultyMap.
     */
    public void assignFacultyAdvisor(Student student) {
        Random generator = new Random();
        // Store current faculty in an array
        Collection<Faculty> values = facultyMap.values();
        Faculty[] advisors = values.toArray(new Faculty[0]);
        student.setStudentAdvisor(advisors[generator.nextInt(advisors.length)]);
    }

    /* Utility */

    /**
     * toString method for prereq collection
     */
    public String prerequisitesToString(Course course,
                                                StringBuilder sb) {
        Map<SubjectCode, Integer> prs = course.getPrerequisites();
        SubjectCode code;      // Subject.CPSC
        int courseNum;         // 2460
        String courseTag;      // "CPSC-2460" key to courseMap
        String prName;         //   prereq name
        int size = prs.size();

        sb.append("[");
        for (Map.Entry<SubjectCode, Integer> entry : prs.entrySet()) {
            code = entry.getKey();
            courseNum = entry.getValue();
            courseTag = code.toString() + "-" + Integer.toString(courseNum);
            prName = courseMap.get(courseTag).getCourseName();
            sb.append("Name=").append(courseTag).append(" : ").append(prName);
            size --;
        }
        sb.append("]");
        return sb.toString();
    }

    /* Getters */
    /**
     * Returns the collection of students.
     * @return studentMap.
     */
    public Map<String, Student> getStudents() {return studentMap;}

    /**
     * Returns the collection of faculty.
     * @return facultyMap.
     */
    public Map<String, Faculty> getFaculty() {return facultyMap;}

    /**
     * Returns the collection of subjects.
     * @return subjectMap.
     */
    public Map<SubjectCode, String> getSubjects() {return subjectMap;}

    /**
     * Returns the collection of courses.
     * @return courseMap.
     */
    public Map<String, Course> getCourses() {return courseMap;}

    /**
     * Returns the collection of sections.
     * @return sectionMap.
     */
    public Map<String, Section> getSections() {return sectionMap;}

    /* Private Fields */
    /** Student map */
    private Map<String, Student> studentMap;

    /** Faculty map */
    private Map<String, Faculty> facultyMap;

    /** Subject map */
    private Map<SubjectCode, String> subjectMap;

    /** Course map */
    private Map<String, Course> courseMap;

    /** Section map */
    private Map<String, Section> sectionMap;
}
