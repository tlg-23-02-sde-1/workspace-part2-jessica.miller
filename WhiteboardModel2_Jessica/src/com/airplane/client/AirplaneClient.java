package com.airplane.client;


import com.airplane.Airplane;
import com.airplane.AirplaneType;

class AirplaneClient {

    public static void main(String[] args) {
        System.out.println(Airplane.getInstanceCount() + " new airplanes have been created.");
        System.out.println();
        //instance1
        Airplane air1 = new Airplane("PDX", "LAX",
                AirplaneType.BOE_737, 8564);
        air1.setAltitude(37000L);
        air1.setFlightTime(3.2);
        air1.setFlightNumber(57468);
        air1.ascent();
        air1.cruise();
        air1.descent();
        System.out.println();

        //instance2
        Airplane air2 = new Airplane("MiamiFL", "ChicagoIL",
                AirplaneType.BOE_767, 2.5, 4564, 20000L);
        air2.ascent();
        air2.cruise();
        air2.descent();
        System.out.println();

        //instance3
        Airplane air3 = new Airplane("BoiseID", "DenverCO", AirplaneType.BOE_747, 5820);
        air3.setFlightTime(1.5);
        air3.setFlightNumber(5836);
        //altitude should be 0
        System.out.println();

        //instance4
        Airplane air4 = new Airplane("DallasTX", "SanFranciscoCA", AirplaneType.NEXT_GEN_737,
                3.0, 3521, 45000L);
        air4.ascent();
        air4.cruise();
        air4.descent();
        System.out.println();

        //toSTRING
        System.out.println(air1);
        System.out.println();
        System.out.println(air2);
        System.out.println();
        System.out.println(air3);
        System.out.println();
        System.out.println(air4);
        System.out.println();

        System.out.println(Airplane.getInstanceCount() + " instances");


    }
}