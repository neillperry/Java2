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
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Hitachi");
    assertEquals(5, tvs.size());
    assertEquals("Hitachi", tvs.iterator().next().getBrand());
  }

  @Test
  public void testFindByBrands_Sony() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Hitachi", "Sony");

    assertEquals(2, tvMap.size());

    Collection<Television> sony = tvMap.get("Sony");
    assertTrue(tvMap.containsKey("Sony"));
    assertEquals(7, sony.size());
  }

  @Test
  public void testFindByBrands_Hitachi() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Hitachi", "Sony");

    assertEquals(2, tvMap.size());

    Collection<Television> hitachi = tvMap.get("Hitachi");
    assertTrue(tvMap.containsKey("Hitachi"));
    assertEquals(5, hitachi.size());
  }

  @Test
  public void testFindByBrands_ZeroArguments() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands();

    assertNotNull(tvMap);
    assertTrue(tvMap.isEmpty());

  }

  @Test
  public void testGetInventory() {


  }



}