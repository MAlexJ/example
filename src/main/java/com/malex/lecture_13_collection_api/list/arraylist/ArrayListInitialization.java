package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/** Initialization ArrayList */
public class ArrayListInitialization extends AbstractUtils {

  @Test
  public void simpleClassTest() {
    // given
    ArrayList<String> list = new ArrayList<>() {};
    list.add("Hello!");

    // when
    list.removeFirst();

    // then
    assertTrue(list.isEmpty());
  }

  /** Container class for immutable collections */
  @Test
  public void listsOfImmutableCollectionsClassTest() {
    // given
    List<String> list = List.of("Hello!");

    // when
    try {
      list.removeFirst();
      fail();
    } catch (java.lang.UnsupportedOperationException e) {
      printlnError(e, 1);
    }

    // then
    assertFalse(list.isEmpty());
  }

  @Test
  public void streamInitializationTest() {
    ArrayList<String> list =
        Stream.of("apple", "banana", "cherry").collect(Collectors.toCollection(ArrayList::new));

    // then
    assertFalse(list.isEmpty());
  }

  @Test
  public void implInnerClassTest() {
    // given
    ArrayList<String> list =
        new ArrayList<>() {
          {
            add("First task");
            add("Second task");
          }
        };

    // when
    var firstElement = list.removeFirst();
    println("Remove first element:", firstElement);

    // then
    assertNotNull(list);
    assertEquals(1, list.size());
    assertEquals("Second task", list.getFirst());
  }
}
