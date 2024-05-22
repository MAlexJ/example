package com.malex.lecture_13_collection_api.map.treeMap;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.TreeMap;
import org.junit.Test;

/**
 * If the specified key is not already associated with a value (or is mapped to null), attempts to
 * compute its value using the given mapping function
 */
public class ComputeIfAbsent extends AbstractUtils {

  /**
   * Returns: the current (existing or computed) value associated with the specified key, or null if
   * the computed value is null
   */
  @Test
  public void simple() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    Integer value = treeMap.computeIfAbsent("key", String::length);

    // Condition 'key.equals("value")' is always 'true'
    treeMap.computeIfAbsent("value", k -> k.equals("value") ? 1 : 0);

    assertEquals(Integer.valueOf(3), value);
    // and
    var firstEntry = treeMap.firstEntry();
    assertEquals("key", firstEntry.getKey());
    assertEquals(Integer.valueOf(3), firstEntry.getValue());
  }

  /**
   * Throws: NullPointerException – if the specified key is null and this map does not support null
   * keys, or the mappingFunction is null
   */
  @Test(expected = NullPointerException.class)
  public void setNullValue() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    Integer value = treeMap.computeIfAbsent("key", null);
    fail();
  }

  @Test
  public void keyHasNullValue() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("key", null);

//    Integer value = treeMap.computeIfAbsent("key", null);
//    assertNull(value);
//
//    var firstEntry = treeMap.firstEntry();
//    assertEquals("key", firstEntry.getKey());
//    assertNull(firstEntry.getValue());
  }
}
