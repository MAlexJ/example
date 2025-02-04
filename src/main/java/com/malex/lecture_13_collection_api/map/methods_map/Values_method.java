package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;

import java.util.Collection;
import java.util.Map;
import org.junit.Test;

/*
 * Returns a Collection view of the values contained in this map.
 * The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa
 *
 * Returns: a collection view of the values contained in this map
 */
public class Values_method {

  @Test
  public void values() {
    // given
    var map = Map.of(1, "one", 2, "two", 3, "three");

    // when
    Collection<String> values = map.values();

    // then
    assertEquals(3, values.size());
  }
}
