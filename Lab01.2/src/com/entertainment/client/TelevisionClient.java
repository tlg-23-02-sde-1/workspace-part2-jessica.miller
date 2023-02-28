package com.entertainment.client;

import com.entertainment.Television;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class TelevisionClient {

    public static void main(String[] args) {

        Television tv3 = new Television("Sony", 50);
        Television tv4 = new Television("LG", 52);

        //COMPARE BOTH TVS
        System.out.println("tv3 == tv4: " + (tv3 == tv4));  //always false
        System.out.println("tv3.equals(tv4): " + tv3.equals(tv4));

        System.out.println(tv3.hashCode());
        System.out.println(tv4.hashCode());

        //Create a Set<Television>
        Set<Television> tvs = new HashSet<>();
        tvs.add(tv3);
        tvs.add(tv4); //rejected as a duplicate

        //Set size = 1
        System.out.println("Size= " + tvs.size());

/*
        Television tv1 = new Television();
        Television tv2 = new Television("Vizio", 42);

        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println();

        //CHANGE CHANNEL
        tv2.changeChannel(10);
        System.out.println(tv2);
        System.out.println();
*/


    }
}