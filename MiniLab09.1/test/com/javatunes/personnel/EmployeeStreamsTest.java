/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class EmployeeStreamsTest {
  
  private Collection<Employee> allEmployees;
  
  @Before
  public void setUp() {
    allEmployees = Department.getDepartment().getEmployees();
  }
  
  /**
   * TASK: find all Employees with salary < 40000.0 and sort them by natural order.
   * Employee implements Comparable: natural order is id increasing.
   * 
   * RESULT: Employees 2 and 15, in that order.
   */

 @Test
 public void testSortThing() {
   List<Employee> employees = allEmployees.stream()
           .filter(emp -> emp.getName().startsWith("P") || emp.getName().startsWith("R"))
           .sorted(Comparator.comparing(emp -> emp.getHireDate()))
           .collect(Collectors.toList());

   assertEquals(3, employees.size());
   assertEquals(Long.valueOf(9),  employees.get(0).getId());
   assertEquals(Long.valueOf(12), employees.get(1).getId());
   assertEquals(Long.valueOf(4), employees.get(2).getId());
 }

@Test
public void testNames() {
   List<Employee> employees = allEmployees.stream()
           .filter(emp -> emp.getHireDate().after(Date.valueOf("2006-01-01")))
           .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
           .peek(emp -> emp.setSalary(emp.getSalary() * 2.0))
           .collect(Collectors.toList());
  assertEquals(10, employees.size());
  assertEquals(Double.valueOf(68000.0),  employees.get(0).getSalary());
  assertEquals(Double.valueOf(190000.0),  employees.get(1).getSalary());
  assertEquals(Double.valueOf(151000.0),  employees.get(2).getSalary());
}


  @Test
  public void testSalaryLessThanSortNaturalOrder() {
    List<Employee> employees = allEmployees.stream()
      .filter(emp -> emp.getSalary() < 40000.0)
      .sorted()  // natural order
      .collect(Collectors.toList());
    
    assertEquals(2, employees.size());
    assertEquals(Long.valueOf(2),  employees.get(0).getId());
    assertEquals(Long.valueOf(15), employees.get(1).getId());
  }
}