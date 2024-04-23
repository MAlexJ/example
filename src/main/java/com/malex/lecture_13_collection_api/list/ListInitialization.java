package com.malex.lecture_13_collection_api.list;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class ListInitialization extends AbstractBase {

  @Test
  public void emptyList() {
    // given
    List<String> emptyArrayList = new ArrayList<>();

    List<String> emptyLinkedList = new LinkedList<>();

    List<Object> emptyList = Collections.emptyList();

    // then
    assertTrue(emptyArrayList.isEmpty());
    assertTrue(emptyLinkedList.isEmpty());
    assertTrue(emptyList.isEmpty());
  }

  @Test
  public void simpleList() {
    // given
    List<String> list1 =
        new ArrayList<>() {
          {
            add("Fist");
            add("Second");
          }
        };

    List<String> list2 =
        new LinkedList<>() {
          {
            add("Fist");
            add("Second");
          }
        };

    // then
    assertFalse(list1.isEmpty());
    assertFalse(list2.isEmpty());
  }

  @Test
  public void streamApiToList() {
    // given
    List<String> list = Stream.of("apple", "banana", "cherry").collect(Collectors.toList());

    // then
    assertTrue(!list.isEmpty());
  }

  /** Returns an immutable list containing only the specified object. */
  @Test
  public void listsOfImmutableCollectionsTest() {
    // given
    List<String> list = Collections.singletonList("X");

    // then
    assertTrue(!list.isEmpty());
  }

  /** Returns an unmodifiable list containing three elements */
  @Test
  public void listsOfImmutableListsTest() {
    // given
    List<String> list = List.of("A", "B", "D");

    // then
    assertTrue(!list.isEmpty());
  }

  /**
   * Returns a fixed-size list backed by the specified array. Changes made to the array will be
   * visible in the returned list, and changes made to the list will be visible in the array.
   */
  @Test
  public void listsOfImmutableListsFormArraysTest() {
    // given
    List<String> list = Arrays.asList("A", "B", "D");

    // then
    assertTrue(!list.isEmpty());
  }
}
