package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>DuplicateSectionException</strong> and its subclasses
 * are a form of Throwable that indicates conditions that a reasonable
 * application might want to catch. This exception is thrown when attempting
 * to add a duplicate section.</p>
 *
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")
public class DuplicateSectionException extends Exception {

	/**
	 * Overloaded constructor for DuplicateSectionException.
	 *
	 * @param msg string
	 */
	public DuplicateSectionException(String msg) {
		super(msg);
	}

	/**
	 * Default constructor for DuplicateSectionException.
	 */
	public DuplicateSectionException() {
		this("Section has already been added.");
	}

}
