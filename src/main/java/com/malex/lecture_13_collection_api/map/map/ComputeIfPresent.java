package com.malex.lecture_13_collection_api.map.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.malex.lecture_13_collection_api.map.AbstractMapBaseUtils;

/*
 * If the value for the specified key is present and non-null,
 * attempts to compute a new mapping given the key and its current mapped value (optional operation).
 */
public class ComputeIfPresent extends AbstractMapBaseUtils {

  @Test
  public void computeIfPresent() {
    // given
    var map = getRandomMap();
    // and
    var key = "A";
    var value = 14;
    // and
    var newValue = 26;
    map.put(key, value);

    // when
    map.computeIfPresent(
        key,
        (keyMap, valMap) -> {
          println("key:", keyMap, ", value:", valMap);
          return newValue;
        });

    // then
    assertThat(map).hasFieldOrPropertyWithValue(key, newValue);
  }

  /*
   * Required:
   *
   * Non-null value for the specified key.
   * If the value for the specified key is present and non-null
   */
  @Test
  public void nullValueForSpecifiedKey() {
    // given
    var map = getRandomMap();
    // and
    var key = "A";
    Integer value = null;

    // and
    map.put(key, value);

    // when
    map.computeIfPresent(
        key,
        (keyMap, valMap) -> {
          /*
           *  value is null
           * this part of the code will not be called
           */
          println("key:", keyMap, ", value:", valMap);
          return 111111111;
        });

    // then
    assertThat(map).hasFieldOrPropertyWithValue(key, null);
  }

  /*
   * Required:
   *
   * If the value for the specified key
   */
  @Test
  public void nullKey() {
    // given
    var map = getRandomMap();
    // and
    var key = "A";

    // when
    map.computeIfPresent(
        key,
        (keyMap, valMap) -> {
          /*
           *  value is null
           * this part of the code will not be called
           */
          println("key:", keyMap, ", value:", valMap);
          return 111111111;
        });

    // then
    assertThat(map).isEmpty();
  }

  /*
   * Required:
   *
   * WTF!
   */
  @Test
  public void returnNullValue() {
    // given
    var map = getRandomMap();
    var key = "A";
    var value = 14;
    map.put(key, value);

    // when
    map.computeIfPresent(
        key,
        (keyMap, valMap) -> {
          /*
           *  value is null
           * this part of the code will not be called
           */
          println("key:", keyMap, ", value:", valMap);
          return null;
        });

    // then
    assertThat(map).isEmpty();
  }
}
