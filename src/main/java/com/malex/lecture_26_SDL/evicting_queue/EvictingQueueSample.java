package com.malex.lecture_26_SDL.evicting_queue;

import com.google.common.collect.EvictingQueue;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;

@Log
public class EvictingQueueSample {

    @Test
    public void test() {
        EvictingQueue<String> queue = EvictingQueue.create(3);
        queue.add("1");
        queue.add("2");
        queue.add("3");
        log.info(queue::toString);

        assertArrayEquals(new LinkedList<>(Arrays.asList("1", "2", "3")).toArray(), queue.toArray());

        /**
         * Adds the given element to this queue. If the queue is currently full,
         * the element at the head of the queue is evicted to make room.
         * Returns: true always
         */
        queue.add("4");
        log.info(queue::toString);
        assertArrayEquals(new LinkedList<>(Arrays.asList("2", "3", "4")).toArray(), queue.toArray());

        /**
         * Adds the given element to this queue. If the queue is currently full,
         * the element at the head of the queue is evicted to make room.
         * Returns: true always
         */
        queue.offer("5");
        log.info(queue::toString);
        assertArrayEquals(new LinkedList<>(Arrays.asList("3", "4", "5")).toArray(), queue.toArray());
    }
}
