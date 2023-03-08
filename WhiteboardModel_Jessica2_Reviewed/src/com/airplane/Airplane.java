package com.airplane;

/**
 * JR: Improved, and demonstrates understanding of program concepts,
 * although improvements needed in a few areas, e.g., better use should be made
 * of the accessor (get/set) methods, which was mentioned in the comments of the
 * original submission.
 *
 * See comments below and in the other classes.
 *
 * Code is clean, readable, well-formatted.
 *
 * Class participation has been good, keep it up.
 *
 * Class names, package names, and overall structure are correct.
 */
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


    /*
     * JR: best to sequence the parameters of your ctors consistently.
     * 1st one: departureLocation, arrivalLocation, airplane, flightNumber
     * 2nd one: departureLocation, arrivalLocation, airplane, flightTime, flightNumber, altitude
     *  swap flightTime and flightNumber and you'll see what I mean.
     *
     * Constructors should delegate to setter methods if you have them, for any
     * validation/conversion they might be doing (now or in the future).
     * We do this in class all the time.
     *
     * You have validation code in setAltitude(), but in the 2nd ctor below you are doing
     * direct field assignment (this.altitude = altitude) instead of delegating to the setter.
     * This means a client can pass you an invalid value for altitude and you'd accept it.
     */
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

    /*
     * JR: generally better to call your own getters in methods that need the field values.
     * This is being done for getAirplane(), but not for any of the others.
     */
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

    /*
     * JR: error message could have slightly better verbiage,
     * and be more concise and diagnostic in nature.
     *
     * Invalid altitude: -1, valid range is 10000 to 60000 (shown here as the final assembly),
     * you would of course not hardcode it like this.
     */
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

    /*
     * JR: name accessor method pairs consistently, in this case it should be:
     *  get/setAirplaneType()
     * But here, one is named getAirplane(), and the other is named setAirplaneType().
     */
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
        return getClass().getSimpleName() + " flight=" + getFlightNumber() +
                " AirplaneType=" + getAirplane() + " departureLocation=" + getDepartureLocation()
                + " arrivalLocation=" + getArrivalLocation() + " flightTime="
                + getFlightTime() + " altitude=" + getAltitude();
    }
}