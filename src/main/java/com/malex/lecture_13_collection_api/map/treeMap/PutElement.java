package com.malex.lecture_13_collection_api.map.treeMap;

import com.malex.utils.AbstractUtils;
import java.util.TreeMap;
import org.junit.Test;

public class PutElement extends AbstractUtils {

  @Test
  public void put() {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("A", 1);
    treeMap.put("A", 2);
    treeMap.put("A", 3);
    println(treeMap);

    treeMap.put("A", null);
    println(treeMap);
  }
}
