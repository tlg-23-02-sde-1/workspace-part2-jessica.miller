package com.javatunes.billing;

public class TaxCalculatorFactory {

    // prevent instantiation with a private constructor
    private TaxCalculatorFactory() {
    }

    /*
    * optional
    * Implement a cache of TaxCalculator objects, such that
    * we return a previously created one if one is in there,
    * and if not, we create and return a new one.
    *
    * hint: you can use a Map<Location, TaxCalculator> for the cache
    *
    * */

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;


        switch(location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }
}