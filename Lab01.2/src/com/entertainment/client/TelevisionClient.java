package com.entertainment.client;

import com.entertainment.Television;


public class TelevisionClient {


    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television(12, "Apple");

        System.out.println(tv1);
        System.out.println(tv2);

        tv2.changeChannel(102);
        System.out.println(tv2);

        Television tv3 = new Television(12, "Apple");
        Television tv4 = new Television(12, "Apple");

        System.out.println(tv3 == tv4);
        System.out.println(tv3.equals(tv4));
    }







}
