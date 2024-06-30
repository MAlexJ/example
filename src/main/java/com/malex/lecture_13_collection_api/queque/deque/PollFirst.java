package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * E pollFirst() - Retrieves and removes the first element of this deque, or returns null if this
 * deque is empty.
 *
 * <p>Returns: the head of this deque, or null if this deque is empty
 */
public class PollFirst extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new ArrayDeque<>();

    assertTrue(deque.add("1"));
    assertTrue(deque.add("2"));
    assertTrue(deque.add("3"));

    /*
    E pollFirst() - Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     */
    assertEquals("1", deque.pollFirst());
    assertEquals("2", deque.pollFirst());
    assertEquals("3", deque.pollFirst());
  }
}
