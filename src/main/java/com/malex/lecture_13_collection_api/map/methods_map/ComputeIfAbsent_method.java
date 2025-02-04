package com.malex.lecture_13_collection_api.map.methods_map;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import org.junit.Test;

/*
 * If the specified key is not already associated with a value (or is mapped to null),
 * attempts to compute its value using the given mapping function and enters it into this map unless null
 * (optional operation).
 */
public class ComputeIfAbsent_method extends AbstractUtils {

  @Test
  public void computeIfAbsent() {
    // given
    var map = new HashMap<String, Integer>();
    // and
    var key = "A";
    var value = 14;

    // current (existing or computed) value associated with the specified key
    Integer existingOrComputedValue =
        map.computeIfAbsent(
            key,
            keyMap -> {
              println("key: " + keyMap);
              return value;
            });

    println("computeIfAbsent: " + existingOrComputedValue);

    assertThat(map).hasFieldOrPropertyWithValue(key, value);
  }

  /*
   *  If the mapping function returns null, no mapping is recorded.
   */
  @Test
  public void computeIfAbsentNullValue() {
    // given
    var map = new HashMap<String, Integer>();
    // and
    var key = "A";
    Integer value = null;

    Integer computeIfAbsent =
        map.computeIfAbsent(
            key,
            keyMap -> {
              println("key: " + keyMap);
              return value;
            });

    println("computeIfAbsent: " + computeIfAbsent);

    assertThat(map).doesNotContainKeys(key);
  }
}
