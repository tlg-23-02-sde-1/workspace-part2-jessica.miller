package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
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
        System.out.println();

        System.out.println("sort by natural order (size)");
        radishes.sort(null); //passing null means natural order
        dump(radishes);
        System.out.println();

        //sort by color, via an instance of RadishColorComparator
        radishes.sort(new RadishColorComparator());
        dump(radishes);
        System.out.println("Comparator sort by color");
        System.out.println();

        //radishes sort by tail length ANONYMOUS CLASS DEFINITION
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                //return wrapper around getTailLength method
                return Double.compare(r1.getTailLength(), r2.getTailLength());
            }
        });
        dump(radishes); //YOU MUST DUMP IT
        System.out.println();

        System.out.println("sort by sprouts via anonymous class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getSprouts(), r2.getSprouts());
            }
        });
        dump(radishes);
        System.out.println();

    }
    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}