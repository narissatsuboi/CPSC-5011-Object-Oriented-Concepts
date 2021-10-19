package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>CourseNotFoundException</strong> and its subclasses are
 * a form of Throwable that indicates conditions that a reasonable
 * application might want to catch. This exception is thrown when attempting
 * to find a course that does not exist.</p>
 * 
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")
public class CourseNotFoundException extends Exception {

    /**
     * Overloaded constructor for CourseNotFoundException.
     *
     * @param msg string
     */
    public CourseNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Default constructor for CourseNotFoundException.
     */
    public CourseNotFoundException() {
        this("Course was not found.");
    }
    
}
