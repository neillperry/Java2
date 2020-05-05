package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

public class EmployeeTestAnonSubclass {

    private Employee emp1;
    private Employee emp2;


    @Before
    public void setUp() throws Exception {
        emp1 = new Employee("Jay", Date.valueOf("1999-08-24")){
            public double pay() { return 0; }
            public double payTaxes() { return 0; }
        };
        emp2 = new Employee("Jay", Date.valueOf("1999-08-24")){
            public double pay() { return 0; }
            public double payTaxes() { return 0; }
        };
    }


    @Test
    public void testEqualsSameAttributes() {
        assertEquals(emp1, emp2);
    }
}
