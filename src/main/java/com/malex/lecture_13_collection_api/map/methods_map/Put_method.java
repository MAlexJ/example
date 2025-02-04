package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

import com.malex.lecture_13_collection_api.map.AbstractMapBaseUtils;
import java.util.Map;
import org.junit.Test;

/*
 * Associates the specified value with the specified key in this map (optional operation).
 * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
 * (A map m is said to contain a mapping for a key k if and only if m. containsKey(k) would return true.)
 *
 * Returns:
 * the previous value associated with key, or null if there was no mapping for key.
 * (A null return can also indicate that the map previously associated null with key,
 * if the implementation supports null values.)
 */
public class Put_method extends AbstractMapBaseUtils {

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
