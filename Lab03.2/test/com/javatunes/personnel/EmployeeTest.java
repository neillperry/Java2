package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @Before
    public void setUp() {
        employee1 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"));
        employee2 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"));
        employee3 = new HourlyEmployee("Susan", Date.valueOf("2014-02-20"));
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
