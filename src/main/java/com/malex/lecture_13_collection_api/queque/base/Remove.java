package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.fail;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class Remove extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("first");
    queue.offer("third");
    queue.offer("last");

    assertEquals("first", queue.remove());
    assertEquals("third", queue.remove());
    assertEquals("last", queue.remove());

    assertNull(queue.remove());
  }

  @Test
  public void emptyQueue() {
    Queue<String> queue = new LinkedList<>();
    queue.offer("first");

    assertEquals("first", queue.remove());
    try {
      assertNull(queue.remove());
      fail();
    } catch (java.util.NoSuchElementException e) {
      // none
    }
  }
}
