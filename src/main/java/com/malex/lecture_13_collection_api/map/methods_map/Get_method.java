package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import java.util.Map;
import org.junit.Test;

/*
 * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
 *
 * Returns:
 * the value to which the specified key is mapped, or null if this map contains no mapping for the key
 *
 * Throws:
 * ClassCastException – if the key is of an inappropriate type for this map (optional)
 * NullPointerException – if the specified key is null and this map does not permit null keys (optional)
 */
public class Get_method {

  @Test
  public void get() {
    Map<Integer, String> map = Map.of(1, "One");

    String val = map.get(1);
    assertEquals(val, "One");

    assertNull(map.get(2));
  }
}
