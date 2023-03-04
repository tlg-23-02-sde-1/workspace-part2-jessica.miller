package com.airplane.test;

import com.airplane.Airplane;
import com.airplane.AirplaneType;

class AirplaneValidationTest {

    public static void main(String[] args) {
        Airplane airA = new Airplane("pdx", "lax", AirplaneType.BOE_737, 3456);
        airA.setAltitude(10000L);
        System.out.println("Altitude: " + airA.getAltitude());

        Airplane airB = new Airplane("pdx", "lax", AirplaneType.BOE_737, 2754);
        airB.setAltitude(60000L);
        System.out.println("Altitude: " + airB.getAltitude());

        Airplane airC = new Airplane("pdx", "lax", AirplaneType.BOE_737, 8456);
        airC.setAltitude(9999L);
        System.out.println("Altitude: " + airC.getAltitude());

        Airplane airD = new Airplane("pdx", "lax", AirplaneType.BOE_737, 1234);
        airD.setAltitude(60100L);
        System.out.println("Altitude: " + airD.getAltitude());
    }
}