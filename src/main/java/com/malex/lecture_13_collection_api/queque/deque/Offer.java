package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * boolean offer(E ...) - Inserts the specified element into the queue represented by this deque (in
 * other words, at the tail of this deque)
 */
public class Offer extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new LinkedBlockingDeque<>();

    assertTrue(deque.offer("A"));
    assertTrue(deque.offer("B"));
    assertTrue(deque.offer("C"));

    assertEquals("A", deque.poll());
    assertEquals("B", deque.poll());
    assertEquals("C", deque.poll());
  }
}
