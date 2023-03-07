/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTestMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
//        testFindById();
//        testFindByKeyword();
//        testFindByCategory();
//        testSize();
//        testGetAll();
//
//        testFindSelfTitled();
//        testFindRockBottom();
//        testGenreCount();
        testIsAtLeast();
    }



    private static void testFindRockBottom() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> item = catalog.findRockBottom(14.00);
        System.out.println("Max Price: " + item);
        System.out.println();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(12L);
        System.out.println("ById: " + item);

        MusicItem notFound = catalog.findById(1012L);
        System.out.println(notFound);
        System.out.println();
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> item = catalog.findByKeyword("Big Ones");
        System.out.println("ByKeyword: " + item);
        System.out.println();
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        for(MusicItem item : items) { // print 1 item at a time
            System.out.println("ByCategory: " + item);
        }
        System.out.println();
    }


    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println("Number of Music items: " + catalog.size()); // size of catalog
        System.out.println();
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println("All Music Items: " + catalog.getAll()); // get all music items
        System.out.println();
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> item = catalog.findSelfTitled();
        System.out.println("Self-Titled: " + item);
    }

    private static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println("GenreCount: " + catalog.genreCount(MusicCategory.POP));

    }

    private static void testIsAtLeast() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.isAtLeast(9.96));
        System.out.println(catalog.isAtLeast(9.95));

    }

}