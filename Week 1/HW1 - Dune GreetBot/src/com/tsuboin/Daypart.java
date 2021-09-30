package com.tsuboin;/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class description
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Daypart {
	public Daypart()
	{

	}
	public String getDaypart()
	{
		var date = new Date();
		var calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		var hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);

		// 10PM - 5AM
		if (hour > 22)
			return "night";
		else if (hour > 17)
			return "evening";
		else if (hour > 12)
			return "noon";
		else if (hour >=5)
			return "morning";
		else
			return "night";
	}
}
