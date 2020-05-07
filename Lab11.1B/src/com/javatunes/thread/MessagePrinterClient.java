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
    // DONE: create two instances of your thread subclass and start them up
    MessagePrinter printer1 = new MessagePrinter("Roses are red");  // take the default interval
    Thread thd1 = new Thread(printer1);
    thd1.start();

    MessagePrinter printer2 = new MessagePrinter("Violets are blue", 1375);
    Thread thd2 = new Thread(printer2);
    thd2.start();
    // just for demonstration purposes - this shows why you don't call run() directly
    // printer1.run();
    // printer2.run();
  }
}