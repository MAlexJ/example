package com.malex.lecture_13_collection_api.map.methods_map;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class Base_initialization extends AbstractUtils {

  @Test
  public void simple() {
    // new HashMap
    Map<String, Integer> constructor = new HashMap<>();

    // Map.of(): this method was introduced in Java 9
    Map<Integer, String> unmodifiableMap = Map.of(1, "A", 2, "B");

    // Anonymous inner class with initialization blocks.
    Map<Integer, String> anonymousInnerClass =
        new HashMap<>() {
          {
            put(1, "A");
          }

          {
            put(2, "B");
          }
        };
  }
}
