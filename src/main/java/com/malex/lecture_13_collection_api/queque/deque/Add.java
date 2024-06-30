package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * When using a capacity-restricted deque, it is generally preferable to use offer.
 *
 * <p>Inserts the specified element into the queue represented by this deque (in other words, at the
 * tail of this deque) if it is possible to do so immediately without violating capacity
 * restrictions, returning true upon success and throwing an IllegalStateException if no space is
 * currently available.
 */
public class Add extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<Integer> deque = new ConcurrentLinkedDeque<>();

    assertTrue(deque.add(1));
    assertTrue(deque.add(2));
    assertTrue(deque.add(3));

    /*
       E pollLast() - retrieves and removes the last element ( tail of this deque) of this deque,
       or returns null if this deque is empty.
       Returns: the tail of this deque, or null if this deque is empty
    */
    assertEquals(3, Optional.ofNullable(deque.pollLast()).orElseThrow().intValue());
    assertEquals(2, deque.pollLast().intValue());
    assertEquals(1, deque.pollLast().intValue());
  }
}
