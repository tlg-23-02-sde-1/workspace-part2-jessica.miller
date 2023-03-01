package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;


import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;

    @Before
    public void setUp() {
       emp = new SalariedEmployee("Mary", Date.valueOf("2010-10-10"), 4500.0);
    }

    @Test
    public void testPay() {
        assertEquals(4500.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(1350.0, emp.payTaxes(), .001);
    }
}