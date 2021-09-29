package com.tsuboin;

/*
 * Program displays a greeting to console. Includes a driver program
 * to store input to dictionary and pass to GreetingGenerator class.
 * Handles custom input.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */


import java.time.LocalTime;
import java.util.HashMap;

public class Driver {
    public static void main(String[] args)
    {
        String name = "Nars";
        String color = "blue";

        String my_greeting = "";

        // Populate hashmap to collect customized fields
        HashMap<String, String> custom_fields = new HashMap<>();
        custom_fields.put("name", name);
        custom_fields.put("color", color);

        // Instantiate GreetingGenerator object with hashmap
        GreetingGenerator greeter = new GreetingGenerator(custom_fields);

        // Generate custom greeting and print to console
        my_greeting = greeter.generateGreeting();

        System.out.println(my_greeting);
    }
}
