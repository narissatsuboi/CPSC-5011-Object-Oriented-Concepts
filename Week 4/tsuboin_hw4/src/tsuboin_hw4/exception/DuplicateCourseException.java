package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>DuplicateCourseException</strong> and its subclasses are a form of Throwable 
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to add a duplicate course.</p>
 * 
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")
public class DuplicateCourseException extends Exception {

    /**
     * Overloaded constructor for DuplicateCourseException.
     *
     * @param msg string
     */
    public DuplicateCourseException(String msg) {
        super(msg);
    }

    /**
     * Default constructor for DuplicateCourseException.
     */
    public DuplicateCourseException() {
        this("Course has already been added.");
    }
    
}
