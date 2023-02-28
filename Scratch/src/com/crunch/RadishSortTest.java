package com.crunch;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 1.4, 2.1, 0));
        radishes.add(new Radish("blue", 1.1, 1.1, 3));
        radishes.add(new Radish("pink", 1.2, 0.0, 5));
        radishes.add(new Radish("yellow", 1.5, 4.5, 1));

        dump(radishes);
        System.out.println("original list");

        radishes.sort(null); //passing null means natural order
        dump(radishes);
        System.out.println("natural order");

        //sort by color, via an instance of RadishColorComparator
        radishes.sort(new RadishColorComparator());
        dump(radishes);
        System.out.println("Comparator sort by color");

    }
    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}