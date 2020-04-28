package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

public class SalariedEmployeeTest {
    private SalariedEmployee employee1;
    private SalariedEmployee employee2;
    private SalariedEmployee employee3;

    @Before
    public void setUp() throws Exception {
        employee1 = new SalariedEmployee("Bob", Date.valueOf("2009-08-12"), 30000.0);
    }

    @Test
    public void pay() {
        assertEquals(30000.0, employee1.pay(), 0.001);
    }


    @Test
    public void payTaxes() {
        assertEquals(9000.0, employee1.payTaxes(), 0.001);
    }

    @Test
    public void equalsTest() {
        employee2 = new SalariedEmployee("Bob", Date.valueOf("2009-08-12"), 30000.0);
        employee3 = new SalariedEmployee("Genghis Khan", Date.valueOf("1182-08-12"), 300000.0);
        assertTrue(employee1.equals(employee2));
        assertFalse(employee1.equals(employee3));
    }

    @Test
    public void hashCodeTest() {
        employee2 = new SalariedEmployee("Bob", Date.valueOf("2009-08-12"), 30000.0);
        employee3 = new SalariedEmployee("Genghis Khan", Date.valueOf("1182-08-12"), 300000.0);
        assertEquals(employee1.hashCode(), employee2.hashCode());
        assertNotEquals(employee1.hashCode(), employee3.hashCode());
    }
}
