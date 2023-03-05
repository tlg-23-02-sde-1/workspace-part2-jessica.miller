/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.corp.client;

import com.javatunes.corp.Corporation;
import gov.irs.IRS; //import

class TaxClient {

    public static void main(String[] args) {
        // get the IRS instance from the only sole point of exsistence in irs interface

         IRS irs = IRS.getInstance(); //doesnt look like an enum

        // uncomment this block after completing the above
        // create the Corporation and register it with the IRS
        Corporation corp = new Corporation("JavaTunes");
        irs.register(corp);

        // IRS collects taxes
        System.out.println("IRS collects taxes");
        irs.collectTaxes();

    }
}