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

public class HourlyEmployee
  extends Employee {
  private Double rate;
  private Double hours;
  
  public HourlyEmployee() {
  }
  
  public HourlyEmployee(String name, Date hireDate) {
    this.setName(name);
    this.setHireDate(hireDate);
  }
  
  public HourlyEmployee(String name, Date hireDate, Double rate, Double hours) {
    this.setName(name);
    this.setHireDate(hireDate);
    setRate(rate);
    setHours(hours);
  }
  
  public Double getRate() {
    return this.rate;
  }
  public void setRate(Double rate) {
    this.rate = rate;
  }
  
  public Double getHours() {
    return this.hours;
  }
  public void setHours(Double hours) {
    this.hours = hours;
  }

  public void pay() {
    System.out.println(super.getName() + " is paid hourly " + getRate() + " " + getHours());
  }
  
  @Override
  public String toString() {
    return super.toString() +
      ", rate=" + getRate() + ", hours=" + getHours();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj instanceof HourlyEmployee) {
      HourlyEmployee other = (HourlyEmployee) obj;
      result = super.equals(obj) &&
              Objects.equals(this.getRate(), other.getRate())  &&
              Objects.equals(this.getHours(), other.getHours());
    }

    return result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getRate(), getHours());
  }

  @Override
  public double payTaxes() {
    double taxes = TaxPayer.SALARIED_TAX_RATE * getRate() * getHours();
    System.out.println(this.getName() + " paid taxes of " + taxes);
    return taxes;
  }
}