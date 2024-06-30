package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * E pollLast() - Retrieves and removes the last element of this deque, or returns null if this
 * deque is empty.
 *
 * <p>Return: the tail of this deque, or null if this deque is empty
 */
public class PollLast extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<String> deque = new ArrayDeque<>();

    assertTrue(deque.add("1"));
    assertTrue(deque.add("2"));
    assertTrue(deque.add("3"));

    /*
    E pollLast() - Retrieves and removes the last element (tail of this deque) of this deque, or returns null if this deque is empty.
     */
    assertEquals("3", deque.pollLast());
    assertEquals("2", deque.pollLast());
    assertEquals("1", deque.pollLast());
  }
}
