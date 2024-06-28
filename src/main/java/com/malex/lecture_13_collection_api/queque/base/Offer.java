package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Inserts the specified element into this queue if it is possible to do so immediately without
 * violating capacity restrictions. When using a capacity-restricted queue, this method is generally
 * preferable to add, which can fail to insert an element only by throwing an exception.
 */
public class Offer extends AbstractTestUtils {
  @Override
  public void test(String description) {
    Queue<String> queue = new LinkedList<>();

    assertTrue(queue.offer("1"));
    assertTrue(queue.offer("2"));

    assertEquals(2, queue.size());
  }
}
