package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class Clear_method extends AbstractUtils {

  /*
   * Removes all of the mappings from this map (optional operation).
   * The map will be empty after this call returns.
   */
  @Test
  public void clear() {
    // given
    Map<Integer, String> map =
        new HashMap<>() {
          {
            put(1, "A");
          }

          {
            put(2, "B");
          }
        };
    println("map", map);

    // when
    map.clear();

    // then
    assertTrue(map.isEmpty());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void clean_unmodifiedMap() {
    // given
    Map<Integer, String> map = Map.of(1, "A");
    println("map", map);

    // then
    map.clear();

    fail();
  }
}
