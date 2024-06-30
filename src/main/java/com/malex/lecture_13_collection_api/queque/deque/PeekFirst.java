package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * E peekFirst() - Retrieves, but does not remove, the first element of this deque, or returns null
 * if this deque is empty.
 */
public class PeekFirst extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new LinkedBlockingDeque<>();

    deque.offer("A");
    deque.offer("B");
    deque.offer("C");

    assertEquals("A", deque.peekFirst());
    assertEquals("A", deque.peekFirst());
    assertEquals("A", deque.peekFirst());
  }
}
