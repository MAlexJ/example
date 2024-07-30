package com.malex.lecture_13_collection_api.map.map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.Test;

import com.malex.lecture_13_collection_api.map.AbstractMapBaseUtils;

/*
 * Associates the specified value with the specified key in this map (optional operation).
 * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
 * (A map m is said to contain a mapping for a key k if and only if m. containsKey(k) would return true.)
 */
public class Put extends AbstractMapBaseUtils {

  /*
   * Associates the specified value with the specified key in this map
   */
  @Test
  public void put() {
    // given
    Map<String, Integer> map = getRandomMap();
    var key = "A";
    var value = 1;

    // when
    Integer put = map.put(key, value);

    // then
    assertNull(put);

    // and
    assertThat(map).hasFieldOrPropertyWithValue(key, value);
  }

  /*
   * If the map previously contained a mapping for the key, the old value is replaced by the specified value
   */
  @Test
  public void replaceOldValue() {
    // given
    Map<String, Integer> map = getRandomMap();
    var key = "A";
    var value = 1;

    // when
    assertNull(map.put(key, value));

    // and
    Integer oldValue = map.put(key, 123);

    // then
    assertNotNull(oldValue);
    assertEquals(value, oldValue.intValue());

    // and
    assertThat(map).hasFieldOrPropertyWithValue(key, 123);
  }
}
