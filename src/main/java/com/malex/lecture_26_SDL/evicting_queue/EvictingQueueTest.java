package com.malex.lecture_26_SDL.evicting_queue;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

public class EvictingQueueTest extends AbstractUtils {

  public static final String QUEUE_NAME = "queue:";

  @Test
  public void test() {
    EvictingQueue<String> queue = EvictingQueue.create(3);
    queue.add("1");
    queue.add("2");
    queue.add("3");
    println(QUEUE_NAME, queue);

    assertEquals(List.of("1", "2", "3"), queue.toList());

    /*
     * Adds the given element to this queue.
     *
     * If the queue is currently full, the element at the head of the queue is evicted to make room.
     */
    queue.add("4");
    println(QUEUE_NAME, queue);
    assertEquals(List.of("2", "3", "4"), queue.toList());

    /*
     * Adds the given element to this queue.
     *
     * If the queue is currently full, the element at the head of the queue is evicted to make room.
     */
    queue.offer("5");
    println(QUEUE_NAME, queue);
    assertEquals(List.of("3", "4", "5"), queue.toList());
  }
}
