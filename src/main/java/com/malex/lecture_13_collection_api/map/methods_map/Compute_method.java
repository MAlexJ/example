package com.malex.lecture_13_collection_api.map.methods_map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

/*
 * Purpose:
 * - Computes a new value for the given key using the remappingFunction and updates it in the map.
 *
 * Key Features:
 * - If the key is absent, null is passed as the current value to remappingFunction.
 * - If remappingFunction returns null, the key is removed.
 * - Allows flexible logic for updating or removing an entry.
 */
public class Compute_method extends AbstractUtils {

  /*
   * public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction )
   *
   * Attempts to compute a mapping for the specified key and its current mapped value
   * (or null if there is no current mapping).
   * For example, to either create or append a String msg to a value mapping:
   * map. compute(key, (k, v) -> (v == null) ? msg : v. concat(msg))
   */
  @Test
  public void compute() {
    var map = new HashMap<String, Integer>();

    Integer put = map.put("A", 1);
    assertNull(put);

    map.compute("A", (key, value) -> value + key.length());

    assertEquals(2, map.get("A").intValue());
  }

  @Test
  public void computeNotExistKey() {
    var map = new HashMap<String, Integer>();
    computeMap(map, "A");
    assertEquals(0, map.get("A").intValue());

    var treeMap = new TreeMap<String, Integer>();
    computeMap(treeMap, "B");
    assertEquals(0, treeMap.get("B").intValue());

    var linkedHashMap = new LinkedHashMap<>(Map.of("C", 1));
    var compute = computeMap(linkedHashMap, "C");
    println(" compute =", compute);
    assertEquals(1, linkedHashMap.get("C").intValue());
  }

  @Test
  public void diffPutVsCompute() {
    var map = new HashMap<String, Integer>();

    /*
    Associates the specified value with the specified key in this map.
    If the map previously contained a mapping for the key, the old value is replaced.

    return: the previous value associated with key, or null if there was no mapping for key
     */
    var putInt = map.put("A", -1);
    println("map.put(A, -1), return = ", putInt);

    putInt = map.put("A", 9);
    println("map.put(A, 9), return = ", putInt);

    assertThat(map).hasFieldOrPropertyWithValue("A", 9);

    /*
    Attempts to compute a mapping for specified key and its current mapped value
    (or null if there is no current mapping).

     return: the new value associated with the specified key, or null if none
     */
    var computeInt =
        map.compute(
            "A",
            (key, value) -> {
              if (value == null) {
                return 0;
              }
              if (value < 0) {
                return -1;
              }
              return 35;
            });
    println(" map.compute(A, (key, value) -> ....... }, return = ", computeInt);
    assertThat(map).hasFieldOrPropertyWithValue("A", 35);
  }

  private Integer computeMap(Map<String, Integer> map, String mKey) {
    return map.compute(
        mKey,
        (key, value) -> {
          println("key =", key, ", value =", value);
          return (value == null) ? 0 : value % 2;
        });
  }
}
