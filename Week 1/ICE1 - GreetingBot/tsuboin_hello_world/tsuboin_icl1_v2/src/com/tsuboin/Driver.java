package com.tsuboin;

/**
 * Program displays a greeting to console. Includes a driver program
 * to call the GreetingGenerator class.
 *
 * @author Narissa Tsuboi
 * @version 1.0
 */

public class Driver {
    public static void main(String[] args)
    {
        System.out.println(GreetingGenerator.get_greeting());
    }
}
