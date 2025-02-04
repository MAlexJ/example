package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import org.junit.Test;

public class ContainsKey_method extends AbstractUtils {

  @Test
  public void containsKey() {
    // given
    var map = new HashMap<String, Integer>();
    map.put("A", 1);

    // when
    boolean containsKey = map.containsKey("A");

    // then
    assertTrue(containsKey);
  }

  @Test
  public void containsKeyWithNullValue() {
    // given
    var map = new HashMap<String, Integer>();
    map.put("A", null);

    // when
    boolean containsKey = map.containsKey("A");

    // then
    assertTrue(containsKey);
  }

  @Test
  public void containsKeyWithNullKey() {
    // given
    var map = new HashMap<String, Integer>();
    map.put(null, null);

    // when
    boolean containsKey = map.containsKey(null);

    // then
    assertTrue(containsKey);
  }

  @Test
  public void emptyMapContains() {
    // given
    var map = new HashMap<String, Integer>();

    // when
    boolean containsKey = map.containsKey(null);

    // then
    assertFalse(containsKey);
  }
}
