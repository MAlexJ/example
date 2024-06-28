package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.LinkedList;
import java.util.Queue;

/** Retrieves and removes the head of this queue, or returns null if this queue is empty. */
public class Poll extends AbstractTestUtils {
  @Override
  public void test(String description) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("first");
    queue.offer("third");
    queue.offer("last");

    assertEquals("first", queue.poll());
    assertEquals("third", queue.poll());
    assertEquals("last", queue.poll());

    assertNull(queue.poll());
    assertNull(queue.poll());
    assertNull(queue.poll());
  }
}
