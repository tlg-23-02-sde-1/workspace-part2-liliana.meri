package com.javatunes.billing;

public class TaxCalculatorFactory {

     // prevent - instantiation - this is an 'all-static' class
    private TaxCalculatorFactory() {

    }

    /*
    * OPTIONAL CHALLENGE:
    * 1. Implement a cache of TaxCalculator objects, such that
    * we return a previously-created one if one is in there,
    * and if not, we create and return  a new one
    *
    * Hint: you can use a Map<Location,TaxCalculator> for the cashe
    * .put()
    *
    * Location |  TaxCalculator
    * -------------------------
    *EUROPE         EuropeTax Object
    *USA            USATax Object
    * ONLINE
    *
    * 2. Create test class
    *
     */





    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;

        switch (location) {
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