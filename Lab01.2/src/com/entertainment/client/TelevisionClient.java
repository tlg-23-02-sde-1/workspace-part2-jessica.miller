package com.entertainment.client;

import com.entertainment.Television;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {

    public static void main(String[] args) {

        Television tv3 = new Television("Sony", 50);
        Television tv4 = new Television("Sony", 50);
        Television tv5 = new Television("Samsung", 47);
        Television tv6 = new Television("LG", 52);

        //COMPARE BOTH TVS
        System.out.println("tv3 == tv4: " + (tv3 == tv4));  //always false
        System.out.println("tv3.equals(tv4): " + tv3.equals(tv4));

        System.out.println(tv3.hashCode());
        System.out.println(tv4.hashCode());

        System.out.println();

        //Create a Set<Television>
        Set<Television> tvs = new TreeSet<>();
        tvs.add(tv3);
        tvs.add(tv4); //rejected as a duplicate
        tvs.add(tv5);
        tvs.add(tv6);

        System.out.println("The size of the Set is: " + tvs.size());
        for (Television tv: tvs) {
            System.out.println(tv);
        }



        //Set size = 1
//        System.out.println("Size= " + tvs.size());

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