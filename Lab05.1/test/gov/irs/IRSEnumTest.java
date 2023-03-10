///*
// * This code is sample code, provided as-is, and we make no
// * warranties as to its correctness or suitability for any purpose.
// *
// * We hope that it's useful to you.  Enjoy.
// * Copyright LearningPatterns Inc.
// */

//package gov.irs;
//
//import com.javatunes.corp.Corporation;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class IRSEnumTest {
//
//    @Test
//    public void normalClientUsage() {
//        //IRSEnum irs = IRSEnum.getInstance();  // client can also say "IRSEnum.INSTANCE"
//
//        IRSEnum irs = IRSEnum.INSTANCE;
//        irs.register(new Corporation("JavaTunes"));
//        irs.collectTaxes();
//    }
//
//    /**
//     * TASK: verify that two calls to IRSEnum.getInstance() return the same instance.
//     */
//    @Test
//    public void getInstance_shouldReturnSameInstance_everyTime() {
//        //both objects reference the same object
//        IRSEnum irs1 = IRSEnum.INSTANCE;
//        IRSEnum irs2 = IRSEnum.INSTANCE;
//        assertTrue(irs1 == irs2); //Jshell tutorial age1 and age2
//        assertSame(irs1, irs2); //uses reference checks
//    }
//
//    /*
//     * Calling a static method loads the .class file.
//     * Show that any class load triggers creation of an enum type's instances.
//     * There is only one instance in this case (IRSEnum.INSTANCE).
//     */
//    @Test
//    public void classload_triggersInstanceCreation() {
//        // TODO: call IRSEnum.touch() and note the output
//        IRSEnum.touch();
//    }
//}