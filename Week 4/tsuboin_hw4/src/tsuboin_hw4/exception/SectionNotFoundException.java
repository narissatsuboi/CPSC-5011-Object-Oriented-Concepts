package tsuboin_hw4.exception;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/**
 * <p>The class <strong>SectionNotFoundException</strong> and its subclasses are a form of Throwable
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to find a section that does not exist.</p>
 *
 * @author Narissa Tsuboi
 */
@SuppressWarnings("serial")
public class SectionNotFoundException extends Exception {

	/**
	 * Overloaded constructor for SectionNotFoundException.
	 *
	 * @param msg
	 */
	public SectionNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * Default exception for SectionNotFoundException.
	 */
	public SectionNotFoundException() {
		this("Section was not found.");
	}
}
