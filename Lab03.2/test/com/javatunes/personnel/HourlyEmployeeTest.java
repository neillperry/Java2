package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee employee1;
    private HourlyEmployee employee2;

    @Before
    public void setUp() throws Exception {
        employee1 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"), 20.0, 15.0);
        employee2 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"), 20.0, 15.0);
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
    public void equalsTest() {
        assertTrue(employee1.equals(employee2));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }
}