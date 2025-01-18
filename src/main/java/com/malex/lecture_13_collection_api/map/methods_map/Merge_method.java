package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public class Merge_method extends AbstractUtils {

  private final Map<Integer, String> unmodifiableMap = Map.of(1, "A", 2, "B", 3, "C");

  private Map<Integer, String> initMap() {
    println("Initial map:", unmodifiableMap);
    return new HashMap<>(unmodifiableMap);
  }

  /*
   * Add a new element to map when key exist in the map
   *
   * Otherwise, replaces the associated value with the results of the given remapping function,
   * or removes if the result is null.
   */
  @Test
  public void add_new_value_with_associated_key() {
    // given
    Map<Integer, String> numberChar = initMap();
    // and
    var existKey = 1;
    var newValue = "New Value";

    // marker for: The function was called.
    AtomicBoolean isFunctionCalled = new AtomicBoolean(false);

    // when: new value associated with the specified key, or null if no value is associated with key
    var newValueAssociatedWithKey =
        numberChar.merge(
            existKey,
            newValue,
            (prev, current) -> {
              isFunctionCalled.set(true);
              println("Remapping function:", prev, ",", current);
              return "%s %s".formatted(current, prev);
            });
    println("New value associated with key:", newValueAssociatedWithKey);

    // then: new value associated with exist key
    assertEquals(newValue + " A", newValueAssociatedWithKey);

    // and: Remapping function was called
    assertTrue(isFunctionCalled.get());
  }

  /*
   * If the specified key is not already associated with a value
   * or is associated with null, associates it with the given non-null value (optional operation).
   */
  @Test
  public void add_new_value_with_not_associated_key() {
    // given
    var numberVsStringMap = initMap();
    // and
    var newKey = Integer.valueOf(-11);
    var newValue = "NEW_VALUE";
    // and:
    AtomicBoolean isFunctionCalled = new AtomicBoolean(false);

    // when
    var newValueAssociatedWithKey =
        numberVsStringMap.merge(
            newKey,
            newValue,

            /*
             * not used !!
             */
            (prev, current) -> {
              isFunctionCalled.set(true);
              println("Remapping function:", prev, current);
              return prev + current;
            });
    println("New value associated with key:", newValueAssociatedWithKey);

    // then
    assertEquals(newValue, newValueAssociatedWithKey);

    // and: Remapping function not called
    assertFalse(isFunctionCalled.get());
    println("map:", numberVsStringMap);
  }

  /*
   * Add element to map
   */
  @Test
  public void add_new_value_and_replace_existing_null_value() {
    // given
    var numberChar = new HashMap<Integer, String>();
    // and
    var key = 0;
    // and
    numberChar.put(key, null);
    println("Initial map:", numberChar);

    // marker for: The function was called.
    AtomicBoolean isFunctionCalled = new AtomicBoolean(false);

    // and
    var newValue = "N_u_L_L";

    // when
    String returnValue =
        numberChar.merge(
            key,
            newValue,
            (prev, current) -> {
              isFunctionCalled.set(true);
              println("Remapping function called:", prev, ",", current);
              return "....Remapping function called....";
            });
    println("New value associated with key:", returnValue);
    // and
    println("Result map:", numberChar);

    // then
    assertEquals(newValue, returnValue);

    // and: Remapping function not called
    assertFalse(isFunctionCalled.get());
    print("Is remapping function called:", isFunctionCalled.get());
  }

  /*
   * Mapping is removed
   *
   * If the remapping function returns null, the mapping is removed.
   */
  @Test
  public void remappingFunctionReturnsNull() {
    // given
    Map<Integer, String> numberChar = initMap();
    // and
    var existKey = 1;
    // marker for: The function was called.
    AtomicBoolean isFunctionCalled = new AtomicBoolean(false);

    // when
    String newValueAssociatedWithSpecifiedKey =
        numberChar.merge(
            existKey,
            "New_Value",
            (prev, current) -> {
              isFunctionCalled.set(true);
              println("Remapping function called:", prev, ",", current);
              return null;
            });
    println(
        "New value associated with key:",
        newValueAssociatedWithSpecifiedKey == null ? "null" : newValueAssociatedWithSpecifiedKey);
    // and
    println("After merge(...) function with null remapping function:", numberChar);

    // then : Key with corresponding value has been removed from the map
    assertNull(numberChar.get(existKey));
    assertEquals(unmodifiableMap.size() - 1, numberChar.size());

    // and: Remapping function was called
    assertTrue(isFunctionCalled.get());
  }
}
