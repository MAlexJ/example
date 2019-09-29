package com.malex.lecture_26_SDL.chapter_4_prority_queue.test;

import com.malex.lecture_26_SDL.chapter_4_prority_queue.impl.PriorityQueueImpl;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.*;

public class PriorityQueueImplTest {

    @Test
    public void test() {
        simpleAssert(new PriorityQueueImpl(10));
        insertAssert(new PriorityQueueImpl(10));
        fullAssert(new PriorityQueueImpl(10), 23);
        fullAssert(new PriorityQueueImpl(10), new Random().nextInt());
    }

    private void fullAssert(PriorityQueueImpl priorityQueue, int num) {
        assertTrue(priorityQueue.isEmpty());
        priorityQueue.insert(num);
        assertFalse(priorityQueue.isEmpty());
        assertEquals(num, priorityQueue.peekMin());
        assertFalse(priorityQueue.isEmpty());
        assertFalse(priorityQueue.isFull());
    }

    private void insertAssert(PriorityQueueImpl priorityQueue) {
        for (int i = 1; i <= 10; i++)
            priorityQueue.insert(i);
        assertFalse(priorityQueue.isEmpty());
        assertTrue(priorityQueue.isFull());
    }

    private void simpleAssert(PriorityQueueImpl pQueue) {
        assertTrue(pQueue.isEmpty());
        assertFalse(pQueue.isFull());
    }

}