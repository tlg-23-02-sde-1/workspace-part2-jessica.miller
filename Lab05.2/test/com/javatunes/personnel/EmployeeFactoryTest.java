package com.javatunes.personnel;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
  private Map<String,String> seMap;
  private Map<String,String> heMap;

  //FIND RECORDING TO FINISH LAB AFTER 330 TODAY

  /**
   * client input request is a Map<String,String>, here's a sample
   * key        value
   * ---        -----
   * type       HE or SE
   * name       Jackie
   * hireDate   1990-08-24
   * 
   * salary     50000.00
   *        OR
   * rate       50.0
   * hours      40.0
   * 
   * NOTES:
   * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
   * 2. this is representative of how UIs send user input data to an application:
   *    - Java Swing UI components all return their input data as strings
   *    - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
   */
  @Before
  public void init() {
    seMap = new HashMap<>();
    seMap.put("type",     "SE"); //INDICATOR!!!!
    seMap.put("name",     "Jackie");
    seMap.put("hireDate", "1990-08-24");
    seMap.put("salary",   "50000.0");
    
    heMap = new HashMap<>();
    heMap.put("type",     "HE");
    heMap.put("name",     "Jackie");
    heMap.put("hireDate", "1990-08-24");
    heMap.put("rate",     "50.0");
    heMap.put("hours",    "40.0");
  }
  
  /**
   * TASK: verify that passing seMap into your
   * factory returns a SalariedEmployee, with all properties set.
   * to check an object's type, you can use instanceof or check its Class object (preferred):
   *   assertEquals(SalariedEmployee.class, emp.getClass())
   */
  @Test
  public void createEmployee_shouldReturnSalariedEmployee_whenTypeSE() {
    Employee emp = EmployeeFactory.createEmployee(seMap);

      //check that 'emp' is exactly a SalariedEmployee object
      assertEquals(SalariedEmployee.class, emp.getClass());

      //check that name, hireDate, and salary are indeed correct
    checkNameHireDate(emp);

    //downcast 'emp' reference to more specific type SalariedEmployee
      SalariedEmployee semp = (SalariedEmployee) emp;
      assertEquals("50000.0", String.valueOf(semp.getSalary())); //auto un-boxed
    //string.valueOf takes anything and returns it as a string
  }

  private void checkNameHireDate(Employee emp) {
    assertEquals("Jackie", emp.getName());
    assertEquals("1990-08-24", emp.getHireDate().toString());
  }

  /**
   * TASK: verify that passing heMap into your factory returns a HourlyEmployee, with all properties set.
   */
  @Test
  public void createEmployee_shouldReturnHourlyEmployee_whenTypeHE() {
    Employee emp = EmployeeFactory.createEmployee(heMap);
    //If it's not an hourly employee the test is over at this line 84
    assertEquals(HourlyEmployee.class, emp.getClass());

    //check that name, hireDate, rate, hours are indeed correct
    //todo: refactor this , so I don't have to say it twice (Dry principal)
    checkNameHireDate(emp);

    //downcast emp reference to a more specific type for hourly employee
    HourlyEmployee hemp = (HourlyEmployee) emp;
    assertEquals(50.0, hemp.getRate(), .001); //expected, actual, delta
    assertEquals(40.0, hemp.getHours(), .001);
  }

  @Test //other option for the below test of expected =
  public void createEmployee_shouldThrowIllegalArgumentException_invalidType_try_catch_fail() {
    seMap.put("type", "INVALID-TYPE"); //THIS HAS TO MATCH ASSERTEQUALS BELOW
      try {
        EmployeeFactory.createEmployee(seMap);
        fail("Should have thrown IllegalArgumentException");
      } catch (IllegalArgumentException e) {
        assertEquals("Invalid type: INVALID-TYPE", e.getMessage());
      }
  }

  /**
   * TASK: verify that passing a map with an invalid "type" value results in IllegalArgumentException.
   * The only valid values for "type" are "HE" or "SE".
   */

  @Test (expected = IllegalArgumentException.class)//not a try catch option
  public void testCreateEmployee_shouldThrowIllegalArgumentException_invalidType() {
    seMap.put("type", "INVALID-TYPE");
    EmployeeFactory.createEmployee(seMap);
    //if you wanted to catch the exception and interrogate it would be if you used try/catch

  }
}