package com.malex.lecture_13_collection.queque;

import com.malex.lecture_13_collection.AbstractTestUtil;
import com.malex.lecture_13_collection.TestNameAnnotation;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.PriorityBlockingQueue;

import static junit.framework.TestCase.*;

/**
 * Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner
 */
public class SimpleQueueExample extends AbstractTestUtil {

    @TestNameAnnotation("All possible implementation of Queue")
    public void simpleTest(String description) {

        Queue<String> linkedList = new LinkedList<>();

        Queue<String> arrayDeque = new ArrayDeque<>();

        Queue<String> priorityQueue = new PriorityQueue<>();

        Queue<String> queue = new PriorityBlockingQueue<>();

        Queue<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
    }


    @TestNameAnnotation("add(), offer(), poll() and remove() method of Queue")
    public void baseFunctionalityTest(String description) {
        Queue<Integer> queue = new ArrayDeque<>();
        print(queue);

        /*
         * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions,
         * returning true upon success and throwing an IllegalStateException if no space is currently available.
         */
        assertTrue(queue.add(1));
        print(queue, "add - 1");
        /*
         * Inserts the specified element into this queue
         */
        assertTrue(queue.offer(2));
        print(queue, "offer - 2");

        assertTrue(queue.offer(3));
        print(queue, "offer - 3");

        /*
         * Retrieves and removes the head of this queue, or returns null if this queue is empty.
         */
        assertEquals(Integer.valueOf(1), queue.poll());
        print(queue, ", poll");

        assertEquals(Integer.valueOf(2), queue.remove());
        print(queue, ", remove");

        assertEquals(Integer.valueOf(3), queue.poll());
        print(queue, ", poll");
    }


    @TestNameAnnotation("peek() method of Queue")
    public void additionalFunctionalityTest(String description) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Hi 1");
        queue.offer("java 2");
        queue.offer("world! 3");
        print(queue);

        assertEquals("Hi 1", queue.peek());
        assertEquals("Hi 1", queue.peek());
        assertEquals("Hi 1", queue.peek());

        queue.poll();
        queue.poll();
        print(queue);

        assertEquals("world! 3", queue.peek());

        assertNotNull(queue.poll());
        print(queue);

        assertNull(queue.poll());
        assertNull(queue.poll());
        assertNull(queue.poll());

        try {
            queue.remove();
            fail();
        } catch (NoSuchElementException ex) {
            //ntd
        }
    }

}
