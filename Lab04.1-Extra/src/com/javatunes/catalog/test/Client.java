package com.javatunes.catalog.test;


import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;
import java.util.*;


public class Client {


    public static void main(String[] args) {

        InMemoryCatalog catalog = new InMemoryCatalog();

        // test the size method
        System.out.println("Catalog size is " + catalog.size());

        System.out.printf("/n");

        //test find by id
        MusicItem isThisAnnieLenox = catalog.findById(1L);
        isThisAnnieLenox.toString();

        System.out.printf("/n");

        // test search by keyword
        Collection<MusicItem> isThisSeal = catalog.findByKeyword("eal");
        System.out.println("Number in array for 'eal' is " + isThisSeal.size());

        System.out.printf("/n");

        //test get all
        Collection<MusicItem> getitAll = catalog.getAll();
        System.out.println("this number should be 14 = " + getitAll.size());

        System.out.printf("/n");

    }


}
