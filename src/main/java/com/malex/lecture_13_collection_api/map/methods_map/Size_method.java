package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;

import java.util.Map;
import org.junit.Test;

/*
 * Returns the number of key-value mappings in this map.
 * If the map contains more than Integer. MAX_VALUE elements, returns Integer. MAX_VALUE.
 *
 * Returns:
 * the number of key-value mappings in this map
 */
public class Size_method {

  @Test
  public void size() {
    // given
    var map = Map.of(1, "one", 2, "two", 3, "three");

    // when
    int size = map.size();

    // then
    assertEquals(3, size);
  }
}
