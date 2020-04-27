/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import static com.entertainment.DisplayType.*;

import com.entertainment.DisplayType;
import com.entertainment.Television;
import com.entertainment.util.TelevisionDisplayAdvisor;

public class TelevisionDisplayAdvisorTest {
  
  public static void main(String[] args) {
    //CREATE some individual instances of Television
    Television tv1 = new Television("Sony", 50, DisplayType.LED);
    Television tv2 = new Television("Apple", 40, DisplayType.OLED);
    Television tv3 = new Television("Panasonic", 30, PLASMA);
    Television tv4 = new Television("LG", 20, LCD);
    Television tv5 = new Television("Vivian Westwood", 10, CRT);



    // NOTE: TelevisionDisplayAdvisor.check() is a static method, so it's called via the classname
    
    // TODO: pass individual instances
    TelevisionDisplayAdvisor.check(tv1);
    System.out.println("-----");
    
    // TODO: pass nothing
    TelevisionDisplayAdvisor.check();
    System.out.println("-----");
    
    // TODO: pass an array - would only do this if you already had one, otherwise just pass individual instances
    Television[] tvArray = {tv1, tv2, tv3, tv4, tv5};
    TelevisionDisplayAdvisor.check(tvArray);
    System.out.println("-----");
  }
}