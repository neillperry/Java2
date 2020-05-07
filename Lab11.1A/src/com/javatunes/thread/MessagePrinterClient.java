/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    MessagePrinter printer1 = new MessagePrinter("bob", 500);
    MessagePrinter printer2 = new MessagePrinter("sue", 750);


    printer1.start();
    printer2.start();
  }
}