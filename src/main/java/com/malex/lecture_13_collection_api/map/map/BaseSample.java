package com.malex.lecture_13_collection_api.map.map;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class BaseSample extends AbstractUtils {

  @Test
  public void simple() {
    Map<String, Integer> map = new HashMap<>();
    boolean empty = map.isEmpty();
    int size = map.size();
    map.clear();

    Integer AddedValue = map.put("a", 1);
    Integer removedValue = map.remove("a");
    Set<Map.Entry<String, Integer>> entries = map.entrySet();
    for (String s : map.keySet()) {
      //
    }


  }
}
