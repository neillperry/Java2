/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import gov.irs.NamedEntity;
import gov.irs.TaxPayer;

import java.sql.Date;
import java.util.Objects;

public abstract class Employee implements TaxPayer, NamedEntity {
  private String name;
  private Date hireDate;
  
  public Employee() {
  }
  
  public Employee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  public void work() {
    System.out.println(getName() + " working hard since " + getHireDate());
  }
  
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Date getHireDate() {
    return this.hireDate;
  }
  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public abstract void pay();

  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj instanceof Employee) {
      Employee other = (Employee) obj;
      result = Objects.equals(this.getName(), other.getName()) &&
              Objects.equals(this.getHireDate(), other.getHireDate());
    }

    return result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHireDate());
  }

}