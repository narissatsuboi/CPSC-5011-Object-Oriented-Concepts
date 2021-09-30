package com.tsuboin;
/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Program displays a greeting to console. Includes a driver program
 * to store input to dictionary and pass to GreetingGenerator class.
 * Handles custom input.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */
public class Driver {
    public static void main(String[] args)
    {
        var name = "Nars";
        var color = "blue";
        var my_greeting = "";


        // Populate dictionary
        var custom_fields = Map.of(
            "$name", "Nars",
            "$color", "blue",
            "$daypart", new Daypart().getDaypart()
        );

        // Instantiate GreetingGenerator object with hashmap
        // Generate custom greeting and print to console
        var greeter = new Greeter();

        my_greeting = greeter.getGreeting(custom_fields);
        System.out.println(my_greeting);
    }
}
