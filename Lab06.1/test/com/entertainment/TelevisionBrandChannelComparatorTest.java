/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Test;

public class TelevisionBrandChannelComparatorTest {
  private Comparator<Television> comparator = new Television.TelevisionBrandChannelComparator();

  @Test
  public void testCompare() throws InvalidChannelException {  // throws clause needed because it's an unhandled checked exception
    Television tv1 = new Television("RCA");
    Television tv2 = new Television("Sony");
    
    assertTrue(comparator.compare(tv1, tv2) < 0);  // RCA < Sony
    
    // if same brand, then compare channel
    tv2.setBrand("RCA");    // now they have the same brand
    tv1.changeChannel(50);  // but tv1's channel is lower
    tv2.changeChannel(60);
    
    assertTrue(comparator.compare(tv1, tv2) < 0);  // RCA = RCA, 50 < 60
    
    tv2.changeChannel(50);  // now all properties are the same
    assertTrue(comparator.compare(tv1, tv2) == 0); // RCA = RCA, 50 = 50
  }

  @Test
  public void testCustomCompare() throws InvalidChannelException {  // throws clause needed because it's an unhandled checked exception
    Television tv1 = new Television("RCA");
    Television tv2 = new Television("Sony");
    tv1.setVolume(14);
    tv2.setVolume(41);

    assertTrue(new Comparator<Television>() { public int compare(Television tv1, Television tv2) {
      return Integer.compare(tv1.getVolume(), tv2.getVolume());
    }}.compare(tv1, tv2) < 0);  // RCA < Sony


    //assertTrue(comparator.compare(tv1, tv2) < 0);  // RCA = RCA, 50 < 60

    tv1.setVolume(41);
    tv2.setVolume(11);
    //assertTrue(comparator.compare(tv1, tv2) == 0); // RCA = RCA, 50 = 50
  }



}