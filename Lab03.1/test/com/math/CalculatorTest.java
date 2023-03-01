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
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    // object(s) under test - called a 'fixture' in JUnit
    private Calculator calc;

    @BeforeClass
    public static void initializeEntireTestRun() {
        System.out.println("initializeEntireTestRun");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");

        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }


    @Test
    public void testDivide() {
        System.out.println("testDivide");

        double result = calc.divide(5, 2);

        assertEquals(2.5, result, .001);
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");

        int result = calc.add(1, 4);

        assertEquals(5, result);  // expected, actual
    }
}