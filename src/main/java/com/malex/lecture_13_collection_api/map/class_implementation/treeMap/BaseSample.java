package com.malex.lecture_13_collection_api.map.class_implementation.treeMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.*;
import org.junit.Test;

public class BaseSample extends AbstractUtils {

  @Test
  public void hierarchy() {
    Map<Object, Object> map = new TreeMap<>();
    // ^ interface
    SequencedMap<Object, Object> sequencedMap = new TreeMap<>();
    // ^ interface
    SortedMap<Object, Object> sortedMap = new TreeMap<>();
    // ^ interface
    NavigableMap<Object, Object> navigableMap = new TreeMap<>();
    // ^ interface
    AbstractMap<Object, Object> abstractMap = new TreeMap<>();
    // ^ abstract class
    TreeMap<Object, Object> treeMap = new TreeMap<>();
  }

  @Test
  public void simpleTest() {
    // given
    SortedMap<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(2, "W");
    treeMap.put(1, "S");
    treeMap.put(3, "X");
    treeMap.put(6, "A");
    println("init:", treeMap);

    // when
    Integer firstKey = treeMap.firstKey();
    println("first key", firstKey);
    // and
    Integer lastKey = treeMap.lastKey();
    println("last key", firstKey);
    // and
    Map.Entry<Integer, String> firstEntry = treeMap.firstEntry();
    Map.Entry<Integer, String> pollFirstEntry = treeMap.pollFirstEntry();
    // and
    Map.Entry<Integer, String> lastEntry = treeMap.lastEntry();
    Map.Entry<Integer, String> polledLastEntry = treeMap.pollLastEntry();
    println("After poll values:", treeMap);

    // then
    assertEquals(Integer.valueOf(1), firstKey);
    assertEquals(Integer.valueOf(6), lastKey);
    // and
    assertEquals(firstEntry, pollFirstEntry);
    assertEquals(lastEntry, polledLastEntry);
  }

  @Test
  public void alwaysThrowException() {
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    try {
      treeMap.putFirst(1, "C");
      fail();
    } catch (UnsupportedOperationException e) {
      // none
    }

    try {
      treeMap.putLast(1, "C");
    } catch (UnsupportedOperationException e) {
      // none
    }
  }
}
