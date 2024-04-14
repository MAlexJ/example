package com.malex.lecture_13_collection_api.list.linkedlist;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class AddElement extends AbstractBase {

  @Test
  public void Add() {
    // given
    LinkedList<String> list = new LinkedList<>(PREPARED_NAMES);

    // when
    boolean added = list.add("New String");

    // then
    assertTrue(added);
    assertEquals("New String", list.getLast());
  }

  @Test
  public void AddLast() {
    // given
    LinkedList<String> list = new LinkedList<>(PREPARED_NAMES);

    // when
    list.addLast("New String");

    // then
    assertEquals("New String", list.getLast());
  }

  @Test
  public void AddFirst() {
    // given
    LinkedList<String> list = new LinkedList<>(PREPARED_NAMES);

    // when
    list.addFirst("New String");

    // then
    assertEquals("New String", list.getFirst());
  }

  @Test
  public void AddByIndex() {
    // given
    LinkedList<String> list = new LinkedList<>(PREPARED_NAMES);

    // when
    list.add(1, "New String");

    // then
    assertEquals("New String", list.get(1));
  }

  @Test
  public void AddCollection() {
    // given
    LinkedList<String> list = new LinkedList<>(PREPARED_NAMES);
    int size = list.size();

    // when
    list.addAll(List.of("A", "B"));

    // then
    assertEquals(size + 2, list.size());

    // and
    assertEquals("B", list.getLast());
    assertEquals("A", list.get(list.size() - 2));
  }

  @Test
  public void AddCollectionByIndex() {
    // given
    LinkedList<String> list = new LinkedList<>(PREPARED_NAMES);
    int size = list.size();

    // when
    list.addAll(0, List.of("A", "B"));

    // then
    assertEquals(size + 2, list.size());

    // and
    assertEquals("B", list.get(1));
    assertEquals("A", list.getFirst());
  }
}
