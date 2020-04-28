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
        employee1 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"), 20.0, 15.0);
        employee2 = new HourlyEmployee("Jane", Date.valueOf("2009-08-12"), 20.0, 15.0);
        employee3 = new HourlyEmployee("Susan", Date.valueOf("2014-02-20"), 33.0, 19.0);
    }

    @Test
    public void equalsTest() {
        assertTrue(employee1.equals(employee2));
        assertFalse(employee1.equals(employee3));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(employee1.hashCode(), employee2.hashCode());
        assertNotEquals(employee1.hashCode(), employee3.hashCode());
    }

}
