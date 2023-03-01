package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {


    public static void main(String[] args) {
        // compare
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        // is tvA == tvB? (same physical object) No they're two separate objects
        System.out.println("tvA == tvB: " + (tvA == tvB)); // always false

        // is tvA.equals(tvB) (equal)
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB)); // true, based on Override condition of equals class

        /*
        // obj w/ diff hashCodes are definitely different
        System.out.println(tvA.hashCode()); // hashCode = ??
        System.out.println(tvB.hashCode()); // hashCode = ??
         */

        // create Set<Television>
        Set<Television> tvs = new TreeSet<>(); // only uses compareTo()
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        // set size() should be 1
        System.out.println("The size of the Set is: " + tvs.size());

        // sorted using HashSet =>
        for (Television tv : tvs) {
            System.out.println(tv);
        }
        System.out.println();
    }

}