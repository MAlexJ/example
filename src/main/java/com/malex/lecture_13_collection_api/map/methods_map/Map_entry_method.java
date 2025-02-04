package com.malex.lecture_13_collection_api.map.methods_map;

import com.malex.utils.AbstractUtils;
import java.util.Map;
import org.junit.Test;

/*
 * Since: Java 9
 *
 * Returns an unmodifiable Map. Entry
 */
public class Map_entry_method extends AbstractUtils {

  @Test
  public void Map_entry_method() {
    Map.Entry<Integer, String> unmodifiableMapEntry = Map.entry(1, "value");
    println("entry:", unmodifiableMapEntry);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void unmodifiableMapEntry() {
    Map.Entry<Integer, String> unmodifiableMapEntry = Map.entry(1, "value");
    unmodifiableMapEntry.setValue("newValue");
  }
}
