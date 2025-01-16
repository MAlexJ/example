package com.malex.lecture_13_collection_api.map.map;

import static junit.framework.TestCase.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/*
 * Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
 *
 * Params: key – the key whose associated value is to be returned defaultValue – the default mapping of the key
 *
 * Returns: the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
 * Throws:
 * or NullPointerException – if the specified key is null and this map does not permit null keys (optional)
 */
public class GetOrDefault_method {

  @Test
  public void getOrDefault_test() {
    // given
    var key = 1;
    var value = "Text";

    // and
    var map = new HashMap<>(Map.of(key, value));

    // when
    var valueByKey = map.getOrDefault(key, "Default");

    // then
    assertEquals(value, valueByKey);
  }

  @Test
  public void default_when_null_test() {
    // given
    var map = new HashMap<>(Map.of(1, "Text"));

    // when
    var valueByKey = map.getOrDefault(-1, "Default");

    // then
    assertEquals("Default", valueByKey);
  }
}
