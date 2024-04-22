package com.malex.lecture_13_collection_api.list.linkedlist;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.LinkedList;
import java.util.function.Predicate;
import org.junit.Test;

public class RemoveElements extends AbstractUtils {

  @Test
  public void removeElementTest() {
    // given
    LinkedList<String> list =
        new LinkedList<>() {
          {
            add("Fist");
            add("Second");
            add("A");
            add("B");
            add("C");
          }
        };
    println("List:", list);

    // when
    // Retrieves and removes the head (first element) of this list.
    String firstElement = list.remove();
    assertEquals("Fist", firstElement);
    println("Removed first element from list:", firstElement);

    // Removes the first occurrence of the specified element from this list, if it is present.
    boolean second = list.remove("Second");
    assertTrue(second);
    println("Removed second element from list:", "Second");

    // Removes the element at the specified position in this list.
    int index = 0;
    String removedByIndex = list.remove(index);
    assertEquals("A", removedByIndex);
    println("Removed element by index:", removedByIndex);

    // and
    println(list);
  }

  @Test
  public void removeFirstOrLastTest() {
    // 1. given
    var first = "First";
    var last = "Last";

    // and
    LinkedList<String> list =
        new LinkedList<>() {
          {
            add(first);
            add("Second");
            add("A");
            add("B");
            add("C");
            add(last);
          }
        };
    println("List:", list);

    // when
    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();

    // then
    assertEquals(first, removedFirst);
    assertEquals(last, removedLast);

    // and
    assertEquals(4, list.size());
    println("List:", list);
  }

  @Test
  public void removeFirstOccurrenceTest() {
    // 1. given
    var first = "First";
    var last = "Last";
    // and
    LinkedList<String> list =
        new LinkedList<>() {
          {
            add(first);
            add(last);
            add(first);
            add(last);
            add("C");
            add(last);
          }
        };
    println("List:", list);

    // when -> true
    boolean removedFirstOccurrence = list.removeFirstOccurrence(first);
    assertTrue(removedFirstOccurrence);
    println("Remove first occurrence:", removedFirstOccurrence, ", list:", list);
    assertEquals(last, list.getFirst());

    // and -> true
    removedFirstOccurrence = list.removeFirstOccurrence(first);
    assertTrue(removedFirstOccurrence);
    println("Remove first occurrence:", removedFirstOccurrence, ", list:", list);
    assertEquals(last, list.getFirst());

    // and -> false
    removedFirstOccurrence = list.removeFirstOccurrence(first);
    assertFalse(removedFirstOccurrence);
    println("Remove first occurrence:", removedFirstOccurrence, ", list:", list);
    assertEquals(last, list.getFirst());
  }

  @Test
  public void removeLastOccurrenceTest() {
    // 1. given
    var first = "First";
    var last = "Last";

    // and
    LinkedList<String> list =
        new LinkedList<>() {
          {
            add(first);
            add(last);
            add(first);
            add(last);
            add("C");
            add(last);
          }
        };
    println("List:", list);

    // when
    boolean removedLastOccurrence = list.removeLastOccurrence(last);
    assertTrue(removedLastOccurrence);
    println("Remove first occurrence:", removedLastOccurrence, ", list:", list);
    assertEquals("C", list.getLast());

    // and
    removedLastOccurrence = list.removeLastOccurrence(last);
    assertTrue(removedLastOccurrence);
    println("Remove first occurrence:", removedLastOccurrence, ", list:", list);
    assertEquals("C", list.getLast());

    // and
    assertEquals(last, list.get(1));
  }

  @Test
  public void removeAllTest() {
    // 1. given
    var first = "First";
    var last = "Last";

    // and
    LinkedList<String> list =
        new LinkedList<>() {
          {
            add(first);
            add("A");
            add("B");
            add("C");
            add(last);
          }
        };
    println("List:", list);

    // when
    boolean removedLastOccurrence = list.removeLastOccurrence(last);
    assertTrue(removedLastOccurrence);
    println("Remove first occurrence:", removedLastOccurrence, ", list:", list);
    assertEquals("C", list.getLast());
  }

  @Test
  public void removeIfTest() {
    // 1. given
    var first = "First";
    var last = "Last";

    // and
    LinkedList<String> list =
        new LinkedList<>() {
          {
            add(first);
            add("A");
            add(first);
            add(first);
            add("C");
            add(last);
            add(first);
          }
        };
    println("List:", list);

    // when
    boolean removeIf =
        // Removes all of the elements of this collection that satisfy the given predicate
        list.removeIf(
            new Predicate<String>() {
              @Override
              public boolean test(String str) {
                return str.equals(first);
              }
            });

    assertTrue(removeIf);
    println("List:", list);
  }
}
