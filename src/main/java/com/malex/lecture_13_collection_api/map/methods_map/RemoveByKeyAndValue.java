package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.HashMap;
import org.junit.Test;

public class RemoveByKeyAndValue {

  @Test
  public void removeByKey() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    boolean firstRemoved = map.remove("first", 11);
    assertTrue(firstRemoved);

    firstRemoved = map.remove("first", 11);
    assertFalse(firstRemoved);
  }

  @Test
  public void removeNullKey() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    boolean firstRemoved = map.remove(null, 11);
    assertFalse(firstRemoved);
  }

  @Test
  public void removeNullValue() {
    var map = new HashMap<String, Integer>();
    map.put("first", 11);

    boolean firstRemoved = map.remove("first", null);
    assertFalse(firstRemoved);
  }
}
