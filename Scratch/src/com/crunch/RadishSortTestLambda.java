package com.crunch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTestLambda {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        // color, size, tailLength, sprouts // add to arrayList
        radishes.add(new Radish("red", 1.1, 2.1, 0));
        radishes.add(new Radish("pink", 3.5, 0.0, 3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white", 1.8, 0.6, 7));

        System.out.println("original lsit");
        dump(radishes);
        System.out.println();

        System.out.println("sort by tailLength (via lambda)");
        // 2 radish coming in, pass comparator
        radishes.sort( (r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);
        System.out.println();

        System.out.println("sort by sprouts (via lambda)");
        // 2 radishes coming in, pass comparator
        radishes.sort((r1, r2) -> Integer.compare(r1.getSprouts(), r2.getSprouts()));
        dump(radishes);
        System.out.println();

        System.out.println("sort by colors (via lambda)");
        radishes.sort((r1, r2) -> r1.getColor().compareTo(r2.getColor()));
        dump(radishes);
        System.out.println();

    }

    // takes a List of Rashes => prints each radish
    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}