package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;


import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Mary", Date.valueOf("2010-10-10"), 4500.0);
        emp2 = new SalariedEmployee("Mary", Date.valueOf("2010-10-10"), 4500.0);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_sameSalary() {
        emp2.setName("Different");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1000.0);
        assertNotEquals(emp, emp2);
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