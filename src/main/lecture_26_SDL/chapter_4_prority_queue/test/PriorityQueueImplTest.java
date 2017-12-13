package chapter_4_prority_queue.test;

import chapter_4_prority_queue.impl.PriorityQueueImpl;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.*;

public class PriorityQueueImplTest
{
    @Test
    public void test()
    {
        test_1(new PriorityQueueImpl(10));
        test_2(new PriorityQueueImpl(10));
        test_3(new PriorityQueueImpl(10), 23);
        test_3(new PriorityQueueImpl(10), new Random().nextInt());
    }

    private void test_3(PriorityQueueImpl priorityQueue, int num)
    {
        assertTrue(priorityQueue.isEmpty());
        priorityQueue.insert(num);
        assertFalse(priorityQueue.isEmpty());
        assertEquals(num, priorityQueue.peekMin());
        assertFalse(priorityQueue.isEmpty());
        assertFalse(priorityQueue.isFull());
    }

    private void test_2(PriorityQueueImpl priorityQueue)
    {
        for (int i = 1; i <= 10; i++)
            priorityQueue.insert(i);
        assertFalse(priorityQueue.isEmpty());
        assertTrue(priorityQueue.isFull());
    }

    private void test_1(PriorityQueueImpl pQueue)
    {
        assertTrue(pQueue.isEmpty());
        assertFalse(pQueue.isFull());
    }

}