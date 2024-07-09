package com.malex.lecture_13_collection_api.map.map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import org.junit.Test;

public class Compute extends AbstractUtils {

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
}
