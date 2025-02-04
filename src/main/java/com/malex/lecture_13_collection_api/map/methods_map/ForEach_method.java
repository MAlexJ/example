package com.malex.lecture_13_collection_api.map.methods_map;

import com.malex.utils.AbstractUtils;
import java.util.Map;
import org.junit.Test;

/*
 * Performs the given action for each entry in this map until all entries have been processed
 * or the action throws an exception.
 */
public class ForEach_method extends AbstractUtils {

  @Test
  public void forEach() {
    // given
    Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");

    // then
    map.forEach((key, value) -> println(key + ": " + value));
  }
}
