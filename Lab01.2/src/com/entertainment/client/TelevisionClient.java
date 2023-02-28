package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {

    public static void main(String[] args) {
        // compare
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("LG", 52);

        // is tvA == tvB? (same physical object) No they're two separate objects
        System.out.println("tvA==tvB: " + (tvA == tvB)); // always false

        // is tvA.equals(tvB) (equal)
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB)); // true, based on Override condition of equals class

        // obj w/ diff hashCodes are definitely different
        System.out.println(tvA.hashCode()); // hashCode = ??
        System.out.println(tvB.hashCode()); // hashCode = ??

        // create Set<Television>
        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB); // should be rejected as 'duplicate'

        // set size() should be 1
        System.out.println("The size of the Set is: " + tvs.size());
    }

}