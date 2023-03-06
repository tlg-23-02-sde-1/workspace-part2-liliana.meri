/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  // findByBrand - return a Collection<Television>
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

    @Test
    public void findByBrand_shouldReturnCollectionWithThatBrand_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony"); // pass valid brand using finder

        assertEquals(7, tvs.size()); // assert tv collection with "sony" is 7
        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

  // findByBrands - return  a Map<String,Collection<Television>>
  @Test
  public void findByBrands_shouldReturnMapWithEntries_whenBrandsPassed() {
      Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "RCA");
      assertEquals(3, tvMap.size());

      Collection<Television> sonyTvs = tvMap.get("Sony");
      assertEquals(7, sonyTvs.size());
        for (Television tv : sonyTvs) {
          assertEquals("Sony", tv.getBrand());
        }

      Collection<Television> zenithTvs = tvMap.get("Zenith");
        assertEquals(9, zenithTvs.size() );

        for (Television tv : zenithTvs) {
            assertEquals("Zenith", tv.getBrand());
        }

      Collection<Television> rcaTvs = tvMap.get("RCA");
      assertEquals(9, rcaTvs.size());

      for (Television tv : rcaTvs) {
          assertEquals("RCA", tv.getBrand());
      }
  }

  @Test
  public void findByBrands_shouldReturnEmptyMap_whenNoBrandsPassed() {
      Map<String,Collection<Television>> tvMap = Catalog.findByBrands();
      assertNotNull(tvMap);
      assertTrue(tvMap.isEmpty());
  }


  @Test
  public void findByBrand_ShouldReturnEmptyCollection_whenBrandNotFound() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  // test unmodifiable Collection
    @Test (expected = UnsupportedOperationException.class)
    public void getInventory_shouldReturnReadOnlyCollection() {
      Collection<Television> inventory = Catalog.getInventory();
      inventory.add(new Television("Sony", 60));
    }

    @Test // remove Duplicates from original (30)
    public void removeDuplicates() {
      // get inventory
      Collection<Television> inventory = Catalog.getInventory();
      assertEquals(30, inventory.size());

      // create new Set by passing 'inventory' into new HashSet<>
      Set<Television> inventorySet = new HashSet<>(inventory); // HashSet does not allow duplicates
      assertEquals(23, inventorySet.size());
    }

    //"Sony", 94 = loudest
    public void testLoudest() {
      Collection<Television> inventory = Catalog.getInventory();
      int maxVolume = 0; // max volume
      Television loudest = null; // loudest Tv object

      for (Television tv : inventory) {
          int tvVolume = tv.getVolume(); // get volume of each tv
          if (tvVolume > maxVolume) {

              maxVolume = tvVolume;
              loudest = tv; // assign tv object as loudest
          }
      }
      assertEquals("Sony", loudest.getBrand());
      assertEquals(94, loudest.getVolume());
    }
}