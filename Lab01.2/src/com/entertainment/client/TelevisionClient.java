package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;


public class TelevisionClient {


    public static void main(String[] args) {
        // create 2 instances of television using the different constructors
        Television tv1 = new Television();
        Television tv2 = new Television("Apple", 12);

        // print out the two televisions to see the different values
        System.out.println("Print out the two televisions");
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println();

        // change the channel on television 2 and verify it has changed
        System.out.println("Change the channel on TV2");
        tv2.changeChannel(102);
        System.out.println(tv2);
        System.out.println();

        // create two more instances of television with identifical properties
        System.out.println("Create 2 more televisions with identical properties");
        Television tv3 = new Television("Apple", 12);
        Television tv4 = new Television("Apple", 12);
        System.out.println();

        // see how the two objects compare
        System.out.println("Compare the two objects");
        System.out.println("First, are they the same object (memory location");
        System.out.println(tv3 == tv4);
        System.out.println("Second, are they identical (same features)");
        System.out.println(tv3.equals(tv4));
        System.out.println();

        //create a set of televisions
        System.out.println("Create a set of televisions and add our 2 identical TVs");
        Set<Television> tvs = new HashSet<Television>();
        tvs.add(tv3);
        tvs.add(tv4);
        System.out.println("Print the size of the set:");
        System.out.println(tvs.size());
        System.out.println("Print out the entire set:");
        System.out.println(tvs);
        System.out.println();
    }







}
