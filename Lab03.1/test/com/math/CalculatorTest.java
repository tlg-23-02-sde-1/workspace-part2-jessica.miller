/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {

    //objects under test - called a "fixture" in JUnit
    private Calculator calc;

    @BeforeClass //expensive!!!
    public static void initializeEntireTestRun() {
        System.out.println("initializeEntireTestRun");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("finalizeTestRun");
    }

    @Before //to eliminate redundancy CALLED A FIXTURE
    /*
    * BEFORE AND AFTER METHODS BRACKET TEST METHODS
    * */
    public void setUp() {
        System.out.println("setup");
        calc = new Calculator();
    }

    //Close and cleanup -------less common than @before
    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(2.5, calc.divide(5, 2), .001);
    }

    @Test
    public void testIsEven(){
        System.out.println("testIsEven");
        assertTrue(calc.isEven(14));
    }
}