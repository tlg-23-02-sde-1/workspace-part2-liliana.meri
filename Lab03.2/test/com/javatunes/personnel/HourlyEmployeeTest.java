package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    //object under test
    private HourlyEmployee emp;

    @Before
    public void setUp() {
         emp = new HourlyEmployee("Mark", Date.valueOf("2020-02-02"), 25.0, 35.0);
    }

    @Test
    public void testPay() {
        // payment = rate * hours
        assertEquals(875.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        // taxes = 25 * payment
        assertEquals(218.75, emp.payTaxes(), .001);

    }


}