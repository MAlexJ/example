package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;

import java.util.Map;
import java.util.Set;
import org.junit.Test;

/*
 * Returns a Set view of the mappings contained in this map
 */
public class EntrySet_method {

  @Test
  public void entrySet() {
    // given
    var map = Map.of(1, "one", 2, "two", 3, "three");

    // when
    Set<Map.Entry<Integer, String>> entries = map.entrySet();

    // then
    assertEquals(3, entries.size());
  }
}
