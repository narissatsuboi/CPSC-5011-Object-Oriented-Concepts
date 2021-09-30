/*
 * Sheila Oh
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author ohsh
 */
public class Driver {

	/**
	 * Test driver for the {@code Stack} class
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final String FILENAME = "data/words.txt";
		File file = new File(FILENAME); 
		Scanner keyboard = new Scanner(file); 
		Stack<String> s = new Stack<String>();
		
		// read from file and push to stack
		while (keyboard.hasNextLine()) 
			s.push(keyboard.nextLine()); 
		
		// close 
		keyboard.close();	
		
		// toString
		System.out.printf("stack: %s\n\n",s.toString());
		
		// pop and print size until empty
		while (!s.isEmpty())
			System.out.printf("popped: %8s,  size:  %s\n", s.pop(), s.size());

	}
		
}
