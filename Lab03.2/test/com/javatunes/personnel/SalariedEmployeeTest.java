package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

public class SalariedEmployeeTest {
    private SalariedEmployee employee1;
    private SalariedEmployee employee2;

    @Before
    public void setUp() throws Exception {
        employee1 = new SalariedEmployee("Bob", Date.valueOf("2009-08-12"), 30000.0);
        employee2 = new SalariedEmployee("Bob", Date.valueOf("2009-08-12"), 30000.0);
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
        assertTrue(employee1.equals(employee2));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }
}
