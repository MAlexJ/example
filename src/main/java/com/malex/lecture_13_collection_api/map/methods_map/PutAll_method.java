package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/*
 * Copies all of the mappings from the specified map to this map (optional operation).
 * The effect of this call is equivalent to that of calling put(k, v) on this map once for each mapping
 */
public class PutAll_method {

  @Test
  public void putAll() {
    // given
    Map<String, String> map = new HashMap<>();

    // and
    Map<String, String> existMap = Map.of("key1", "value1", "key2", "value2");

    // when
    map.putAll(existMap);

    // then
    assertEquals(existMap, map);
  }
}
