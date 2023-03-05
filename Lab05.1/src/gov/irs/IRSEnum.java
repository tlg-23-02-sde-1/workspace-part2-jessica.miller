/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
//----------------------SINGLETON LAB---------------------------//
package gov.irs;

import java.util.ArrayList;
import java.util.Collection;

//Shows class loading
enum IRSEnum implements IRS {
    INSTANCE; //Calls the Ctor internally

    // BUSINESS CODE
    private final Collection<TaxPayer> payers = new ArrayList<>();

    public void collectTaxes() {
        for (TaxPayer payer : payers) {
            payer.payTaxes();
        }
    }

    public void register(TaxPayer payer) {
        payers.add(payer);
    }

}
    //TO MAKE LAZY
//make class nonpublic
//create IRS interface and sign IRS contract with implements



















//CONSTRUCTOR IS ALWAYS PRIVATE IN AN ENUM
 // constructor - just so we can see when INSTANCE is created
// IRSEnum() {
//     System.out.println("--IRSEnum ctor: the instance has been created"); -- means this is a diagnostic message
//   }

   // not needed - just makes the enum look more like a regular singleton
    //client side code below
//    public static IRSEnum getInstance() {
//       return INSTANCE;
//    }

    // static initializer block - just so we can see when IRSEnum.class is loaded
   // a class load triggers creation of an enum's instances (only one in this case - INSTANCE) whatever you put in there is loaded
//   static {
//      System.out.println("--IRSEnum class loaded");
//   }

  // superfluous static method that shouldn't be here
  // if it gets called, IRSEnum.class is loaded and INSTANCE is created (prematurely)
//   public static void touch() {
//      // no-op
//  }
