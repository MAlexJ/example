package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/*
 * If the specified key is not already associated with a value (or is mapped to null) associates it with the given value
 * and returns null, else returns the current value (optional operation).
 *
 * Params:
 * key – key with which the specified value is to be associated value – value to be associated with the specified key
 *
 * Returns:
 * the previous value associated with the specified key, or null if there was no mapping for the key.
 * (A null return can also indicate that the map previously associated null with the key,
 * if the implementation supports null values.)
 */
public class PutIfAbsent_method {

  @Test
  public void putIfAbsent_add_new_value() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "a");
    /*
     * equivalent: V v = map. get(key);  if (v == null) v = map. put(key, value);  return v;
     */
    map.putIfAbsent(2, "b");
    assertEquals(2, map.size());
  }

  @Test
  public void putIfAbsent_exist_value() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "a");
    /*
     * Equivalent:
     * V v = map. get(key);  if (v == null) v = map. put(key, value);  return v;
     *
     * return: previous value associated with the specified key
     */
    var prevValueAssociatedWithKey = map.putIfAbsent(1, "b");
    assertNotNull(prevValueAssociatedWithKey); // prev = a

    assertEquals(1, map.size());
    assertEquals("a", map.get(1));
  }

  @Test
  public void putIfAbsent_null_key() {
    Map<Integer, String> map = new HashMap<>();
    map.put(null, "a");
    /*
     * return: previous value associated with the specified key
     */
    var prevValueAssociatedWithKey = map.putIfAbsent(null, "b");
    assertNull(prevValueAssociatedWithKey);

    assertEquals(1, map.size());
    assertEquals("a", map.get(null));
  }
}
