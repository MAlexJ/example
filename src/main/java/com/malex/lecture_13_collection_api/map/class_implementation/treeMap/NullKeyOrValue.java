package com.malex.lecture_13_collection_api.map.class_implementation.treeMap;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.TreeMap;
import org.junit.Test;

public class NullKeyOrValue extends AbstractUtils {

  @Test(expected = NullPointerException.class)
  public void putNullKey() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put(null, 1);
    fail();
  }

  @Test
  public void putNullValue() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("key", null);
  }

  @Test(expected = NullPointerException.class)
  public void computeIfAbsentNullValue() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.computeIfAbsent("key", null);
    fail();
  }

  @Test(expected = NullPointerException.class)
  public void computeIfPresentNullValue() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("key", 1);
    treeMap.computeIfPresent("key", null);
    fail();
  }

  /**
   * If the specified key is not already associated with a value (or is mapped to null) associates
   * it with the given value and returns null, else returns the current value.
   */
  @Test
  public void putIfAbsentNullValue() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    var nullKey = treeMap.putIfAbsent("key", null);
    assertNull(nullKey);
    println(treeMap);

    var key = treeMap.putIfAbsent("key", 1);
    assertNull(key);
    println(treeMap);

    key = treeMap.putIfAbsent("key", 2);
    assertEquals(Integer.valueOf(1), key);
    println(treeMap);

    key = treeMap.putIfAbsent("key", 3435);
    assertEquals(Integer.valueOf(1), key);
    println(treeMap);
  }
}
