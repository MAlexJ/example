package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * boolean offerLast(E ...) - inserts the specified element at the end of this deque unless it would
 * violate capacity restrictions. When using a capacity-restricted deque, this method is generally
 * preferable to the addLast method, which can fail to insert an element only by throwing an
 * exception.
 */
public class OfferLast extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<Integer> deque = new ArrayDeque<>();

    /*
    boolean offerLast(E ...) - inserts the specified element at the end of this deque
     */
    assertTrue(deque.offerLast(1));
    assertTrue(deque.offerLast(2));
    assertTrue(deque.offerLast(3));

    /*
    E pool() - Retrieves and removes the head of the queue represented by this dequ
     */
    assertEquals(1, deque.poll().intValue());
    assertEquals(2, deque.poll().intValue());
    assertEquals(3, deque.poll().intValue());
  }
}
