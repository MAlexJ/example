package com.malex.lecture_13_collection_api.map.methods_map;

import com.malex.utils.AbstractUtils;
import java.util.Map;
import org.junit.Test;

public class OfEntries_method extends AbstractUtils {

  /*
   * Returns an unmodifiable map containing keys and values extracted from the given entries.
   * The entries themselves are not stored in the map.
   */
  @Test
  public void ofEntries() {
    Map.Entry<Integer, String> entry1 = Map.entry(1, "Hello");
    Map.Entry<Integer, String> entry2 = Map.entry(2, "Java");
    Map.Entry<Integer, String> entry3 = Map.entry(3, "Dev");

    Map<Integer, String> map = Map.ofEntries(entry1, entry2, entry3);
    println("map: %s".formatted(map));
  }
}
