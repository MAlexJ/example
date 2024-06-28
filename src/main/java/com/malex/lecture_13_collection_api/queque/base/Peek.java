package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 * E peek() - Retrieves, but does not remove, the head of this queue, or returns null if this queue
 * is empty.
 */
public class Peek extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("first");
    queue.offer("third");
    queue.offer("last");

    assertEquals("first", queue.peek());
    assertEquals("first", queue.peek());
    assertEquals("first", queue.peek());

    assertEquals(3, queue.size());
  }

  @Test
  public void emptyQueue() {
    Queue<String> queue = new LinkedList<>();

    String peek = queue.peek();
    println("peek: " + peek);

    assertNull(peek);
    assertNull(peek);
    assertNull(peek);
  }
}
