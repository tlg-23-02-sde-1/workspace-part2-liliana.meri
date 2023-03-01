package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    // object under test - called a 'fixture' in JUnit
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
       emp1 = new SalariedEmployee("Mary", Date.valueOf("2014-02-06"), 4500.0);
       emp2 = new SalariedEmployee("Mary", Date.valueOf("2014-02-06"), 4500.0);
    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(emp1.hashCode(), emp2.hashCode());

    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("DIFFERENT");

        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("1990-09-09"));

        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1000.0);

        assertNotEquals(emp1, emp2);
    }

    //
    @Test
    public void testPay() {
        assertEquals(4500.0, emp1.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(1350.0, emp1.payTaxes(), .001);
    }
}