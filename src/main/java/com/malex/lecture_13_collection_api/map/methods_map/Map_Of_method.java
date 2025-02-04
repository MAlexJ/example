package com.malex.lecture_13_collection_api.map.methods_map;

import com.malex.utils.AbstractUtils;
import java.util.Map;
import org.junit.Test;

/*
 * This method was introduced in Java 9
 */
public class Map_Of_method extends AbstractUtils {

  /*
   * Returns an unmodifiable map containing zero mappings.
   */
  @Test(expected = UnsupportedOperationException.class)
  public void of_empty_method() {
    Map<Object, Object> unmodifiableMap = Map.of();

    // Immutable object is modified  - > UnsupportedOperationException
    unmodifiableMap.put(new Object(), "value");
  }

  @Test
  public void of_method() {
    Map<Integer, String> integerStringMap = Map.of(1, "a", 2, "b", 3, "c");
    println("map:", integerStringMap);
  }
}
