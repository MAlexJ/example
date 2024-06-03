package com.malex.lecture_13_collection_api.map.map;

import static junit.framework.TestCase.*;

import java.util.HashMap;
import java.util.TreeMap;
import org.junit.Test;

/**
 * Removes the mapping for a key from this map if it is present (optional operation) <br>
 * Returns the value to which this map previously associated the key, or null if the map contained
 * no mapping for the key.
 */
public class RemoveByKey {

  @Test
  public void removeByKey() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    Integer first = map.remove("first");
    assertEquals(Integer.valueOf(11), first);
  }

  @Test
  public void removeEmptyByKey() {
    var map = new HashMap<String, Integer>();
    Integer first = map.remove("first");
    assertNull(first);

    var treeMap = new TreeMap<String, Integer>();
    assertNull(treeMap.remove("first"));
  }

  @Test
  public void removeNullKey() {
    var hashMap = new HashMap<String, Integer>();
    Integer first = hashMap.remove(null);
    assertNull(first);

    var treeMap = new TreeMap<String, Integer>();
    try {
      treeMap.remove(null);
      fail();
    } catch (NullPointerException e) {
      // nothing
    }
  }
}
