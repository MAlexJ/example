package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * E peak() - Retrieves, but does not remove, the head of the queue represented by this deque (in
 * other words, the first element of this deque), or returns null if this deque is empty
 */
public class Peek extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new LinkedBlockingDeque<>();

    deque.offer("A");
    deque.offer("B");
    deque.offer("C");

    assertEquals("A", deque.peek());
    assertEquals("A", deque.peek());
    assertEquals("A", deque.peek());
  }
}
