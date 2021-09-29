package com.tsuboin;

import java.util.HashMap;

/**
 * The GreetingGenerator implements an application that displays
 * "Hello World" to standard output.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */

public class GreetingGenerator
{
	private static HashMap<String, String> custom_fields;

	public GreetingGenerator(HashMap<String, String> custom_fields)
	{
		GreetingGenerator.custom_fields = custom_fields;
	}

	public String generateGreeting()
	{
		String template_str = "Hello $name - that's a nice $color shirt.";
		template_str = template_str.replace("$name", custom_fields.get(
			"name"));
		template_str = template_str.replace("$color", custom_fields.get(
			"color"));

		return template_str;
	}
}
