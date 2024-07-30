package com.malex.lecture_13_collection_api.map;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public abstract class AbstractMapBaseUtils extends AbstractUtils {

  private final Random random = new Random();

  protected Map<String, Integer> getRandomMap() {
    int nextInt = random.nextInt(3);
    Map<String, Integer> map =
        switch (nextInt) {
          case 0 -> new HashMap<>();
          case 1 -> new TreeMap<>();
          case 2 -> new LinkedHashMap<>();
          default -> new Hashtable<>();
        };
    println("\n map:", map.getClass().getName());
    return map;
  }
}
