package com.malex.lecture_13_collection_api.map.class_implementation.treeMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.util.TreeMap;
import org.junit.Test;

/**
 * If the specified key is not already associated with a value (or is mapped to null) associates it
 * with the given value and returns null, else returns the current value.
 */
public class PutIfAbsent extends AbstractUtils {

  @Test
  public void putIfAbsent() {
    // given
    TreeMap<String, Integer> treeMap = new TreeMap<>();

    Integer firstPutIfAbsent = treeMap.putIfAbsent("A", 1);
    println("the first use of putIfAbsent:" + firstPutIfAbsent);
    assertNull(firstPutIfAbsent);

    Integer secondPutIfAbsent = treeMap.putIfAbsent("A", 2);
    println("the second use of putIfAbsent:", secondPutIfAbsent);
    assertEquals(Integer.valueOf(1), secondPutIfAbsent);

    println(treeMap);
  }

  @Test
  public void putIfAbsentValueNull() {
    // given
    TreeMap<String, Integer> treeMap = new TreeMap<>();

    Integer firstPutIfAbsent = treeMap.putIfAbsent("A", null);
    println("the first use of putIfAbsent:" + firstPutIfAbsent);
    assertNull(firstPutIfAbsent);
    println(treeMap);

    Integer secondPutIfAbsent = treeMap.putIfAbsent("A", 2);
    println("the second use of putIfAbsent:", secondPutIfAbsent);
    assertNull( secondPutIfAbsent);
    println(treeMap);
  }
}
