package com.tsuboin;

import java.time.LocalTime;
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

		// Add daypart to the dictionary
		this.generateDayPart();
	}

	private void generateDayPart()
	{
		String daypart = "";

		LocalTime the_time = LocalTime.now();
		LocalTime time0 = LocalTime.parse("00:00:00.00");
		LocalTime time1 = LocalTime.parse("05:00:00.00");
		LocalTime time2 = LocalTime.parse("12:01:00.00");
		LocalTime time3 = LocalTime.parse("12:00:00.00");
		LocalTime time4 = LocalTime.parse("17:01:00.00");
		LocalTime time5 = LocalTime.parse("17:00:00.00");
		LocalTime time6 = LocalTime.parse("22:00:00.00");
		LocalTime time7 = LocalTime.parse("22:01:00.00");
		LocalTime time8 = LocalTime.parse("23:59:59.59");

		// the_time is after 5AM but before 12:01 PM
		if (the_time.isAfter(time1) && the_time.isBefore(time2))
			daypart = "Good morning";
		else if ((the_time.isAfter(time3) && the_time.isBefore(time4)))
			daypart = "Good afternoon";
		else if ((the_time.isAfter(time5) && the_time.isBefore(time6)))
			daypart = "Good evening";
		else if ((the_time.isAfter(time7) && the_time.isBefore(time8)) ||
			(the_time.isAfter(time0)) && the_time.isBefore(time1) ||
			the_time == time0)
			daypart = "Good night";

		// Store daypart delimiter to dictionary
		custom_fields.put("daypart", daypart);
	}

	public String generateGreeting()
	{
		String template_str = "$daypart $name - that's a nice $color shirt.";
		template_str = template_str.replace("$daypart", custom_fields.get(
			"daypart"));
		template_str = template_str.replace("$name", custom_fields.get(
			"name"));
		template_str = template_str.replace("$color", custom_fields.get(
			"color"));

		return template_str;
	}
}
