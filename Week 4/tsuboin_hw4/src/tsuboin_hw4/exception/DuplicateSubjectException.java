package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>DuplicateSubjectException</strong> and its subclasses are a form of Throwable
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to add a duplicate subject.</p>
 *
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")
public class DuplicateSubjectException extends Exception {

	/**
	 * Overloaded constructor for DuplicateSubjectException.
	 *
	 * @param msg string
	 */
	public DuplicateSubjectException(String msg) {
		super(msg);
	}

	/**
	 * Default constructor for DuplicateSubjectException.
	 */
	public DuplicateSubjectException() {
		this("Subject has already been added.");
	}

}
