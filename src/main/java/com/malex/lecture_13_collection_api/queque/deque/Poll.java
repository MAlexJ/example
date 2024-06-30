package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * E poll() - Retrieves and removes the head of the queue represented by this deque (in other words,
 * the first element of this deque), or returns null if this deque is empty.
 */
public class Poll extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new ArrayDeque<>();

    assertTrue(deque.add("1"));
    assertTrue(deque.add("2"));
    assertTrue(deque.add("3"));

    /*
    E poll() - Retrieves and removes the head of the queue represented by this deque
     */
    assertEquals("1", deque.poll());
    assertEquals("2", deque.poll());
    assertEquals("3", deque.poll());
  }
}
