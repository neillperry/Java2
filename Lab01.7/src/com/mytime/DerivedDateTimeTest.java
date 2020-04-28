/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;


import java.time.LocalDate;
import java.time.Period;

public class DerivedDateTimeTest {
  /**
   * main() calls each of the test methods in turn (currently commented out).
   * To run one test method at a time, uncomment the call to the one you want to execute.
   */
  public static void main(String[] args) {
    testPresidentsFirst100Days();
    testPopularBirthdays();
    // testEarlyRetirement();
    // testLaborDay();
    // testElectionDay();
    // testAnniversary();
  }
  
  /**
   * TASK: new American presidents are often measured by their performance during the first 100 days in office.
   * Inauguration Day 2017 is Jan 20.  When is this president's 100-day deadline?
   * 
   * RESULT: 
   */
  public static void testPresidentsFirst100Days() {
    Period first = Period.ofDays(100);
    LocalDate inauguration = LocalDate.of(2017, 1, 20 );
    LocalDate first100 = inauguration.plus(first);
    System.out.println(String.valueOf(first100));

  }

  /**
   * TASK: Certain times of the year seem to have more birthdays than other times.
   * Some believe that this is because more babies are conceived during certain times of year.
   * Below, assume a due date 38 weeks after conception, during a non-leap-year.
   * 
   * RESULT: 
   */
  public static void testPopularBirthdays() {
    Period gestation = Period.ofMonths(9);
    // TODO: what is the average birthday of someone conceived on Valentine's Day?
    LocalDate valentine = LocalDate.of(2000, 02, 14);
    LocalDate valentineBaby = valentine.plus(gestation);
    System.out.println(String.valueOf(valentineBaby));

    // TODO: what is the average birthday of someone conceived on New Year's Eve (after midnight)?
    LocalDate newYearDay = LocalDate.of(2000, 01, 01);
    LocalDate newYearBaby = newYearDay.plus(gestation);
    System.out.println(String.valueOf(newYearBaby));
  }
  
  /**
   * TASK: you've saved diligently your whole life and plan to retire as soon as
   * you can take distributions from your 401(k) penalty-free, which is when you turn 59 1/2.
   * When will / did you retire?
   * 
   * RESULT: 
   */
  public static void testEarlyRetirement() {
    // TODO
  }
  
  /**
   * TASK: when was Labor Day during the year you were born?
   * Note: start with a LocalDate equal to your birthday.
   * Note: Labor Day is the first Monday in Sept.
   * 
   * RESULT: 
   */
  public static void testLaborDay() {
    // TODO
  }
  
  /**
   * OPTIONAL: Election Day in the United States is defined as the Tuesday immediately after the 1st Monday in November.
   * When is Election Day 2024?
   * 
   * RESULT: 
   */
  public static void testElectionDay() {
    // TODO
  }
  
  /**
   * OPTIONAL: Akesh and Samanta were married on 6/6/1969.
   * They are planning their 50th wedding anniversary, and would like to throw a big party.
   * If their anniversary does not fall on a Saturday, they'd like to have their party the following Saturday.
   * What is the date of the party?
   * 
   * RESULT: 
   */
  public static void testAnniversary() {
    // TODO
  }
}