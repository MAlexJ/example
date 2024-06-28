package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import com.malex.lecture_13_collection_api.TestNameAnnotation;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 * E element() - Retrieves, but does not remove, the head of this queue. <br>
 * This method differs from peek only in that it throws an exception if this queue is empty.
 */
public class Element extends AbstractTestUtils {

  @TestNameAnnotation("E element() method of Queue")
  @Override
  public void test(String description) {
    // given
    Queue<Integer> queue = new LinkedList<>();

    // when
    assertTrue(queue.offer(1));
    assertTrue(queue.offer(2));
    assertTrue(queue.offer(3));

    // then
    assertEquals(1, queue.element().intValue());
    assertEquals(1, queue.element().intValue());
    assertEquals(1, queue.element().intValue());
  }

  /** if this queue is empty then that it throws an exception */
  @Test
  public void emptyQueue() {
    Queue<Integer> queue = new LinkedList<>();

    try {
      queue.element();

      fail();
    } catch (java.util.NoSuchElementException e) {
      // none
      printlnError(e, 5);
    }
  }
}
