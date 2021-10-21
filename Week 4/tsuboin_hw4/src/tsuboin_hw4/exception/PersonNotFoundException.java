package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>PersonNotFoundException</strong> and its subclasses are
 * a form of Throwable that indicates conditions that a reasonable
 * application might want to catch. This exception is thrown when attempting
 * to find a person that does not exist.</p>
 *
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")
public class PersonNotFoundException extends Exception {

	/**
	 * Overloaded constructor for PersonNotFoundException.
	 *
	 * @param msg string
	 */
	public PersonNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * Default constructor for PersonNotFoundException.
	 */
	public PersonNotFoundException() {
		this("Person was not found.");
	}

}
