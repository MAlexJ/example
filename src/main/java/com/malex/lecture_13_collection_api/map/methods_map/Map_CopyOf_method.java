package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/*
 * Since: Java 10
 *
 * Returns an unmodifiable Map containing the entries of the given Map.
 * The given Map must not be null, and it must not contain any null keys or values.
 *
 * If the given Map is subsequently modified, the returned Map will not reflect such modifications.
 */
public class Map_CopyOf_method {

  @Test
  public void map_copyOf() {

    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "one");
    hashMap.put(2, "two");
    hashMap.put(3, "three");

    Map<Integer, String> unmodifiableMap = Map.copyOf(hashMap);

    assertEquals(hashMap, unmodifiableMap);
  }
}
