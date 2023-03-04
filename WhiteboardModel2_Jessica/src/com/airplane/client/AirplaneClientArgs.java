package com.airplane.client;

/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

import com.airplane.Airplane;
import com.airplane.AirplaneType;

import java.util.Arrays;

/**
 * Intended usage (by human):
 *  $ java AirplaneClientArgs <departureLocation> <arrivalLocation> <airplane>
 *
 * Example:
 *  $ java AirplaneClientArgs PDX LAX BOE_737
 *
 * GOAL:
 *  Create an instance of Airplane with the specifications (values) provided by the user.
 */
class AirplaneClientArgs {

    public static void main(String[] args) {
        // must first check for the presence of your (required) 3 arguments
        if (args.length < 4) {
            String usage = "Usage: java AirplaneClientArgs <departureLocation> <arrivalLocation> <airplane> <flightNumber>";
            String example = "Example: java AirplaneClientArgs PDX LAX BOE_747 4567";
            String note = "Support airplanes are: " + Arrays.toString(AirplaneType.values());
            System.out.println(usage);
            System.out.println(example);
            System.out.println(note);

            return;  // early return from main(), application exits
        }
        // at this point, you can safely proceed, because you got your arguments
        // first, let's just show that we got them
        System.out.println("You provided " + args.length + " arguments");

        //FIRST CONVERT STRING INPUTS TO PROPER TYPES
        String departureLocation = args[0];
        String arrivalLocation = args[1];
        AirplaneType airplane = AirplaneType.valueOf(args[2].toUpperCase());
        int flightNumber = Integer.parseInt(args[3]);

        //now create an instance of Airplane of these converted inputs
        Airplane airA = new Airplane(departureLocation, arrivalLocation, airplane, flightNumber);

        System.out.println("BON VOYAGE");
        System.out.println(airA);
    }
}
