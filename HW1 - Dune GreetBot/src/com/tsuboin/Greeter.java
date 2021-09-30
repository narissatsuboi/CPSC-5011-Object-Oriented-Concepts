package com.tsuboin;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import java.util.Map;

/**
 * The Dune Greeter class modifies and returns a template greeting
 * with custom fields passed from the driver.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Greeter {
	private String template = "Hello $name - that's a nice $color shirt this " +
		"$daypart.";

	/**
	 * Constructor initializes private fields.
	 */
	public Greeter ()
	{ }

	/**
	 * Modifies template greeting with string interpolation on '$'
	 * delimiter. Accesses custom fields  from custom_fields.
	 *
	 * @return modified greeting
	 */
	public String getGreeting(Map<String, String> map)
	{
		// Building our actual message:
		// make a copy of the template
		var msg = template;
		// for each key in dict
		for (var entrySet : map.entrySet())
		{
			// search the msg for the key and replace it with the key's
			// value
			msg = msg.replace(entrySet.getKey(), entrySet.getValue());
		}

		return msg;
	}
}
