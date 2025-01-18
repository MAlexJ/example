package com.malex.lecture_13_collection_api.map.class_implementation.hashMap;

import static junit.framework.TestCase.assertEquals;

import java.util.HashMap;
import org.junit.Test;

public class NullKey {

  @Test
  public void nullKeyTest() {
    // given
    var map = new HashMap<String, String>();

    // when
    map.put(null, "xxx");

    // then
    assertEquals(1, map.size());
    // and
    assertEquals(map.get(null), "xxx");
  }
}
