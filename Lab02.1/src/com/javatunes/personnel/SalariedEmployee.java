/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import gov.irs.TaxPayer;

import java.sql.Date;
import java.util.Objects;

public class SalariedEmployee
        extends Employee {
  private Double salary;
  
  public SalariedEmployee() {
  }

  public SalariedEmployee(String name, Date hireDate) {
    this.setName(name);
    this.setHireDate(hireDate);
  }
  
  public SalariedEmployee(String name, Date hireDate, Double salary) {
    this.setName(name);
    this.setHireDate(hireDate);
    setSalary(salary);
  }
  
  public Double getSalary() {
    return this.salary;
  }
  public void setSalary(Double salary) {
    this.salary = salary;
  }


  public void pay() {
    System.out.println(super.getName() + " is paid " + getSalary());
  }

  @Override
  public String toString() {
    return super.toString() +
      ", salary=" + getSalary();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj instanceof SalariedEmployee) {
      SalariedEmployee other = (SalariedEmployee) obj;
      result = super.equals(obj) &&
              Objects.equals(this.getSalary(), other.getSalary());
    }

    return result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getSalary());
  }

  @Override
  public double payTaxes() {
    double taxes = TaxPayer.SALARIED_TAX_RATE * getSalary();
    System.out.println(this.getName() + " paid taxes of " + taxes);
    return taxes;
  }

}