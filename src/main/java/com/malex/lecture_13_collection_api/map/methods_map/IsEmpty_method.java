package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/*
 * Returns true if this map contains no key-value mappings
 */
public class IsEmpty_method {

  @Test
  public void isEmpty() {
    // given
    Map<Integer, String> map =
        new HashMap<>() {
          {
            put(1, "A");
          }
        };

    // when
    assertFalse(map.isEmpty());

    // and
    map.clear();

    // then
    assertTrue(map.isEmpty());
  }
}
