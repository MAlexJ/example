package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * void addFirst(E ...) - Inserts the specified element at the front of this deque if it is possible
 * to do so immediately without violating capacity restrictions, throwing an IllegalStateExceptio
 */
public class AddFirst extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<Integer> deque = new ConcurrentLinkedDeque<>();

    /*
    void addFirst(E ...) - Inserts the specified element at the front of this deque
    */
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);

    /*
       E pollLast() - retrieves and removes the last element ( tail of this deque) of this deque,
       or returns null if this deque is empty.
       Returns: the tail of this deque, or null if this deque is empty
    */
    assertEquals(1, Optional.ofNullable(deque.pollLast()).orElseThrow().intValue());
    assertEquals(2, deque.pollLast().intValue());
    assertEquals(3, deque.pollLast().intValue());
  }
}
