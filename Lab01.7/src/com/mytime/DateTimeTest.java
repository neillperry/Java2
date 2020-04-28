/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;

import java.awt.image.SinglePixelPackedSampleModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.time.LocalDateTime;
import java.text.DateFormat;

public class DateTimeTest {
  /**
   * main() calls each of the test methods in turn (currently commented out).
   * To run one test method at a time, uncomment the call to the one you want to execute.
   */
  public static void main(String[] args) throws ParseException {
    testNow();
    testCreate();
    testParse();
    testFormat();
  }

  /**
   * TASK: create current date, time, and date-time via now() and then print them.
   */
  public static void testNow() {
    LocalDate today = LocalDate.now();
    LocalDateTime now = LocalDateTime.now();
    Date date = new Date(System.currentTimeMillis());

    System.out.println("Local Date: " + today);
    System.out.println("Date Time: " + now);
    System.out.println("Date: " + date);
  }
  
  /**
   * TASK: implement the TODOs and print your results.
   */
  public static void testCreate() {
    // TODO: create your birthday via of(). What day of the week were you born on?
    LocalDate dob = LocalDate.of(1776, 7, 4 );

    // TODO: use of() to create a value representing the 1st lunar landing - it happened on 7/20/69 at 3:18pm Eastern Time.
    LocalDate moon = LocalDate.of(1969, 7, 20 );
    System.out.println(dob);
    System.out.println(moon);
  }

  /**
   * TASK: implement the TODOs and print your results.
   */
  public static void testParse() throws ParseException {
    // TODO: create your birthday by parsing a text representation in standard format.
    LocalDate dob = LocalDate.parse("1776-07-04");
    // OPTIONAL: now create it by parsing text in the form "2/6/2014" (this is Feb 6, not Jun 2).
    LocalDate dob2 = LocalDate.parse("07/04/1776", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    System.out.println(dob);
    System.out.println(dob2);
  }
  
  /**
   * TASK: create formatted display strings for the date below, in the specified formats.
   */
  public static void testFormat() {
    LocalDate hastings = LocalDate.of(1066, 10, 14);
    
    // TODO: 10/14/1066
    String formattedDate2 = hastings.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    System.out.println(formattedDate2);

    // TODO: 14-10-1066
    String formattedDate3 = hastings.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    System.out.println(formattedDate3);

    // OPTIONAL: October 14, 1066
    String formattedDate = hastings.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    System.out.println(formattedDate);
  }
}