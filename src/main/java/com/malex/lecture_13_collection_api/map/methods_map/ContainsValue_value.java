package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.HashMap;
import org.junit.Test;

public class ContainsValue_value {

  @Test
  public void containsValue() {
    // given
    var map = new HashMap<String, Integer>();
    map.put("a", 1);

    // when
    boolean containsValue = map.containsValue(1);

    // then
    assertTrue(containsValue);
  }

  @Test
  public void containsNullValue() {
    // given
    var map = new HashMap<String, Integer>();
    map.put("a", null);

    // when
    boolean containsValue = map.containsValue(null);

    // then
    assertTrue(containsValue);
  }

  @Test
  public void emptyMapContainsNullValue() {
    // given
    var map = new HashMap<String, Integer>();

    // when
    boolean containsValue = map.containsValue(null);

    // then
    assertFalse(containsValue);
  }
}
