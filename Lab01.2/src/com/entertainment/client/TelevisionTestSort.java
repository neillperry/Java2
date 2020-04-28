/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import java.util.Arrays;
import java.util.List;

import com.entertainment.ChannelDisallowedException;
import com.entertainment.InvalidChannelException;
import com.entertainment.Television;
import com.entertainment.TelevisionChannelComparator;

public class TelevisionTestSort {
  
  public static void main(String[] args) throws InvalidChannelException, ChannelDisallowedException {

    List<Television> tvList = null;

    try {
      // dataset for testing
      tvList = createTelevisionList();

    } catch (InvalidChannelException e) {
      e.printStackTrace();
    }


    // sort by natural order and print
    tvList.sort(null);

    System.out.println("Sorted by brand (natural order)");
    for (Television tv : tvList) {
      System.out.println(tv);
    }
    System.out.println();

    //
    // TODO: uncomment this to test your comparator class
    // sort by supplied Comparator and print
    tvList.sort(new TelevisionChannelComparator());

    System.out.println("Sorted by channel");
    for (Television tv : tvList) {
      System.out.println(tv);
    }
    System.out.println();

  }
  
  // dataset for testing
  private static List<Television> createTelevisionList() throws InvalidChannelException, ChannelDisallowedException {
    Television tv1 = new Television("Zenith", 30);
    Television tv2 = new Television("Hitachi", 10);
    Television tv3 = new Television("Sony", 50);
    Television tv4 = new Television("RCA", 25);
    Television tv5 = new Television("Hitachi", 5);
    Television tv6 = new Television("Sony", 40);

    tv1.changeChannel(44);
    tv2.changeChannel(9);
    tv3.changeChannel(13);

    return Arrays.asList(tv1, tv2, tv3, tv4, tv5, tv6);
  }
}