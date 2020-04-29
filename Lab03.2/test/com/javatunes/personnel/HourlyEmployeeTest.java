package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee employee1;
    private HourlyEmployee employee2;
    private HourlyEmployee employee3;

    @Before
    public void setUp() throws Exception {
        employee1 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"), 20.0, 15.0);
        employee2 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"), 20.0, 15.0);
        employee3 = new HourlyEmployee("Susan", Date.valueOf("2014-02-20"), 33.0, 19.0);
    }

    @Test
    public void pay() {
        assertEquals(225.0, employee1.pay(), 0.001);
    }

    @Test
    public void payTaxes() {
        assertEquals(75.0, employee1.payTaxes(), 0.001);
    }

    @Test
    public void equalsSameTest() {
        assertTrue(employee1.equals(employee2));
    }

    @Test
    public void equalsDifferentTest() {
        assertFalse(employee1.equals(employee3));
    }


    @Test
    public void hashCodeSameTest() {
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    public void hashCodeDifferentTest() {
        assertNotEquals(employee1.hashCode(), employee3.hashCode());
    }
}