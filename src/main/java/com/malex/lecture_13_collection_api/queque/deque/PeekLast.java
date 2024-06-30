package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * E peekLast() - Retrieves, but does not remove, the last element of this deque, or returns null if
 * this deque is empty.
 */
public class PeekLast extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new LinkedBlockingDeque<>();

    deque.offer("A");
    deque.offer("B");
    deque.offer("C");

    /*
    E peekLast() - Retrieves, but does not remove, the last element of this deque
     */
    assertEquals("C", deque.peekLast());
    assertEquals("C", deque.peekLast());
    assertEquals("C", deque.peekLast());
  }
}
