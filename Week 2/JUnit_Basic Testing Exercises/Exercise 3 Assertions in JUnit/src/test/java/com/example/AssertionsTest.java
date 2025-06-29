package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testCalculatorAssertions() {
        Calculator calc = new Calculator();

        assertEquals(10, calc.add(6, 4));

        assertTrue(calc.isPositive(7));

        assertFalse(calc.isPositive(-3));

        assertNull(calc.getGreeting(null));

        assertNotNull(calc.getGreeting("Alice"));

        String str = "Hi";
        assertSame(str, str);

        assertNotSame(new String("Hi"), new String("Hi"));
    }
}

