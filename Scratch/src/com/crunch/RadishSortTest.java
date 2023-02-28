package com.crunch;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        // color, size, tailLength, sprouts // add to arrayList
        radishes.add(new Radish("red", 1.1, 2.1, 0));
        radishes.add(new Radish("pink", 3.5, 0.0, 3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        System.out.println(radishes); // print all radishes inLine

        dump(radishes); // print 1 radish at a time

        // sortBy: Natural order
        radishes.sort(null);
        dump(radishes); // natural order
        System.out.println();

        // sortBy: color, instance of RadishColorComparator
        radishes.sort(new RadishColorComparator());
        dump(radishes);

    }

    // takes a List of Rashes => prints each radish
    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}