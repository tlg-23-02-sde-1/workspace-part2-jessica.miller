package com.airplane;

public class Airplane {
    private String departureLocation;
    private String arrivalLocation;
    private double flightTime;
    private int flightNumber;
    private long altitude;
    private AirplaneType airplane;

    public static final long MAX_ALTITUDE = 60000L;
    public static final long MIN_ALTITUDE = 10000L;

    private static int instanceCount = 0;


    //CONSTRUCTOR
    public Airplane(String departureLocation, String arrivalLocation, AirplaneType airplane, int flightNumber) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.airplane = airplane;
        this.flightNumber = flightNumber;

        instanceCount++;
    }

    public Airplane(String departureLocation, String arrivalLocation, AirplaneType airplane,
                    double flightTime, int flightNumber, long altitude) {
        this(departureLocation, arrivalLocation, airplane, flightNumber);
        this.flightTime = flightTime;
        this.altitude = altitude;
    }

    //BUSINESS METHODS
    public void ascent() {
        System.out.println("Flight# " + flightNumber + ", " + getAirplane() +
                ", is taking off at " + departureLocation + ". Our flight time today is "
                + flightTime + ". Happy travels!");
    }

    public void descent() {
        System.out.println("Prepare for landing! The forecast for "
                + arrivalLocation + " is sunny with a high of 85 degrees.");
    }

    public void cruise() {
            System.out.println("We have reached a cruising altitude of "
                    + getAltitude() + " feet, you may now use the lavatory" +
                    " or electronics in airplane mode");

    }


    //GETTERS AND SETTERS
    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public double getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(double flightTime) {
        this.flightTime = flightTime;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        if (altitude >= MIN_ALTITUDE && altitude <= MAX_ALTITUDE) {
            this.altitude = altitude;
        } else {
            System.out.println("Plane is not within cruising height: " + altitude +
                    "...Please reach " + MIN_ALTITUDE + " feet and below " + MAX_ALTITUDE
                + " feet to cruise");
        }
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public AirplaneType getAirplane() {
        return airplane;
    }

    public void setAirplaneType(AirplaneType airplane) {
        this.airplane = airplane;
    }

    //TO STRING

    @Override
    public String toString() {
//        return String.format("Flight#%s, Departure=%s, Arrival=%s, ClassificationType=%s, FlightTime=%s, Altitude=%s",
//                getFlightNumber(), getDepartureLocation(), getArrivalLocation(),
//                getFlightTime(), getAltitude());
        return getClass().getSimpleName() + " flight=" + getFlightNumber() + " AirplaneType=" + getAirplane() + " departureLocation=" + getDepartureLocation()
                + " arrivalLocation=" + getArrivalLocation() + " flightTime=" + getFlightTime() + " altitude=" + getAltitude();
    }
}