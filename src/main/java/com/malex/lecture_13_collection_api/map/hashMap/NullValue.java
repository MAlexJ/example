package com.malex.lecture_13_collection_api.map.hashMap;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.Test;

public class NullValue {

  @Test
  public void nullKeyTest() {
    // given
    var map = new HashMap<String, String>();

    // when
    map.put("X", null);

    // then
    assertEquals(1, map.size());
    // and
    assertThat(map).hasFieldOrPropertyWithValue("X", null);
  }
}
