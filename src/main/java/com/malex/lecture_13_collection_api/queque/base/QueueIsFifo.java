package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class QueueIsFifo extends AbstractTestUtils {
  @Override
  public void test(String description) {
    Queue<Integer> queue = new ArrayDeque<>();
    // firs in
    queue.add(1);
    queue.add(2);
    queue.add(3);

    Iterator<Integer> iterator = queue.iterator();
    assertEquals(1, iterator.next().intValue());
    assertEquals(2, iterator.next().intValue());
    assertEquals(3, iterator.next().intValue());
    assertEquals(3, queue.size());

    // first out
    assertEquals(1, queue.poll().intValue());
    assertEquals(2, queue.poll().intValue());
    assertEquals(3, queue.poll().intValue());
  }
}
