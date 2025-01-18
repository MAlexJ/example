package com.malex.lecture_13_collection_api.map.class_implementation.hashtable;

import com.malex.utils.AbstractUtils;
import java.util.Hashtable;
import java.util.Map;
import org.junit.Test;

public class BaseHashTable extends AbstractUtils {

  @Test
  public void initialization() {
    Hashtable<String, Integer> hashtable = new Hashtable<>();
    hashtable.put("A", 1);
    println(hashtable);

    Hashtable<Integer, String> ht =
        new Hashtable<>() {
          {
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
          }
        };
    println(ht);

    Map<Integer, String> htMap =
        new Hashtable<>() {
          {
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
          }
        };
    println(htMap);
  }
}
