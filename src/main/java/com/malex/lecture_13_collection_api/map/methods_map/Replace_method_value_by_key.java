package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/*
 * Replaces the entry for the specified key only if it is currently mapped to some value (optional operation).
 *
 * Returns: the previous value associated with the specified key, or null if there was no mapping for the key.
 */
public class Replace_method_value_by_key extends AbstractUtils {

  private static final Integer VALUE_11 = 11;
  private static final String KEY_AS_TEXT = "key_as_text";
  private static final Map<String, Integer> UNMUTABLE_MAP = Map.of(KEY_AS_TEXT, VALUE_11);

  /*
   * Simple initialization:
   * Map<String, Integer> init =  new HashMap<>() {{ put(MAP_KEY_TEXT, MAP_VALUE_11) }}
   */
  private Map<String, Integer> initHashMap() {
    var map = new HashMap<>(UNMUTABLE_MAP);
    println("HashMap initialization:", map);
    return map;
  }

  @Test
  public void replace_with_key() {
    // given
    Map<String, Integer> map = initHashMap();

    // when
    var previousValueAssociatedWithKey = map.replace(KEY_AS_TEXT, 22);
    println("Previous value associated with key:", previousValueAssociatedWithKey);

    // then
    assertEquals(VALUE_11, previousValueAssociatedWithKey);
    println("HahMap after replacement:", map);
  }

  @Test
  public void replace_with_null_key() {
    // given
    var map = new HashMap<String, Integer>();
    map.put(null, VALUE_11);
    println("HashMap initialization:", map);

    // when: replace with the null key
    var previousValueAssociatedWithKey = map.replace(null, 22);
    println("Previous value associated with key:", previousValueAssociatedWithKey);

    // then: old value
    assertEquals(Integer.valueOf(11), previousValueAssociatedWithKey);
    println("HahMap after replacement:", map);
  }

  @Test
  public void replace_with_not_exist_key() {
    // given
    Map<String, Integer> map = initHashMap();

    // when
    var previousValueAssociatedWithKey = map.replace("Not_exist_key", 22);
    println(
        "Previous value associated with key:",
        previousValueAssociatedWithKey == null ? "null" : previousValueAssociatedWithKey);

    // then
    assertNull(previousValueAssociatedWithKey);
    println("HahMap after replacement:", map);
  }

  @Test
  public void replace_with_not_exist_null_key() {
    // given
    var map = initHashMap();

    // when: replace with the null key
    var previousValueAssociatedWithKey = map.replace(null, 22);
    println(
        "Previous value associated with key:",
        previousValueAssociatedWithKey == null ? "null" : previousValueAssociatedWithKey);

    // then
    assertNull(previousValueAssociatedWithKey);
    println("HahMap after replacement:", map);
  }

  @Test
  public void replace_with_null_value() {
    // given
    var map = initHashMap();

    // when
    Integer previousValueAssociatedWithKey = map.replace(KEY_AS_TEXT, null);
    println("Previous value associated with key:", previousValueAssociatedWithKey);

    // then
    assertEquals(VALUE_11, previousValueAssociatedWithKey);
    println("HahMap after replacement:", map);
  }
}
