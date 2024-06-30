package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.LinkedList;

/**
 * boolean offerFirst(E ...) - inserts the specified element at the front of this deque unless it
 * would violate capacity restrictions. When using a capacity-restricted deque, this method is
 * generally preferable to the addFirst method, which can fail to insert an element only by throwing
 * an exception.
 */
public class OfferFirst extends AbstractTestUtils {

  /** Inserts the specified element at the front of this deque */
  @Override
  public void test(String description) {
    Deque<String> deque = new LinkedList<>();

    /*
    boolean offerFirst(E ...) - Inserts the specified element at the front of this deque
      */
    assertTrue(deque.offerFirst("A"));
    assertTrue(deque.offerFirst("B"));
    assertTrue(deque.offerFirst("C"));

    /*
       E pollLast() - retrieves and removes the last element ( tail of this deque) of this deque,
       or returns null if this deque is empty.
       Returns: the tail of this deque, or null if this deque is empty
    */
    assertEquals("A", deque.pollLast());
    assertEquals("B", deque.pollLast());
    assertEquals("C", deque.pollLast());
  }
}
