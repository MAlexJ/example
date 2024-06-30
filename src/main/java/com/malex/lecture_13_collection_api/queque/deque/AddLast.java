package com.malex.lecture_13_collection_api.queque.deque;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * void addLast(E ...) - inserts the specified element at the end of this deque if it is possible to
 * do so immediately without violating capacity restrictions, throwing an IllegalStateException
 */
public class AddLast extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Deque<Integer> deque = new ConcurrentLinkedDeque<>();

    /*
    void addLast(E ...) - inserts the specified element at the end of this deque
    */
    deque.addLast(1);
    deque.addLast(2);
    deque.addLast(3);

    /*
       E pollLast() - retrieves and removes the last element ( tail of this deque) of this deque,
       or returns null if this deque is empty.
       Returns: the tail of this deque, or null if this deque is empty
    */
    assertEquals(3, Optional.ofNullable(deque.pollLast()).orElseThrow().intValue());
    assertEquals(2, pollLastSafely(deque).intValue());
    assertEquals(1, pollLastSafely(deque).intValue());
  }

  private <T> T pollLastSafely(Deque<T> deque) {
    return Optional.ofNullable(deque.pollLast()).orElseThrow();
  }
}
