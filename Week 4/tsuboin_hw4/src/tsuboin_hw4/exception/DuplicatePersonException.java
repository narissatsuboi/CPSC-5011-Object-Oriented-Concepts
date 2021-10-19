package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>DuplicatePersonException</strong> and its subclasses are a form of Throwable 
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to add a duplicate person.</p>
 * 
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")


public class DuplicatePersonException extends Exception {

    /**
     * Overloaded constructor for DuplicatePersonException.
     *
     * @param msg string
     */
    public DuplicatePersonException(String msg) {
        super(msg);
    }

    /**
     * Default constructor for DuplicatePersonException.
     */
    public DuplicatePersonException() {
        this("Person has already been added.");
    }
    
}
