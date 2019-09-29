package com.malex.lecture_26_SDL.chapter_4_queue.test_queue;

import com.malex.lecture_26_SDL.chapter_4_queue.IQueue;
import com.malex.lecture_26_SDL.chapter_4_queue.impl.LoopQueue;
import com.malex.lecture_26_SDL.chapter_4_queue.impl.MyQueue;
import com.malex.lecture_26_SDL.chapter_4_queue.impl.MyQueueShift;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestMyQueue {

    @Test
    public void test() {
        // MyQueue
        checkSimpleInsertDelete(new MyQueue(10));
        checkForOverflow(new MyQueue(2));
        test_3(new MyQueue(3));
        test_4(new MyQueue(5));
        try {
            test_5_add_after_delete_simple(new MyQueue(3));
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            //ignore
        }
        try {
            test_6_add_after_delete(new MyQueue(3));
        } catch (ArrayIndexOutOfBoundsException ex) {
            // ignore
        }

        // MyQueueShift
        checkSimpleInsertDelete(new MyQueueShift(10));
        checkForOverflow(new MyQueueShift(2));
        test_3(new MyQueueShift(3));
        test_4(new MyQueueShift(5));
        test_5_add_after_delete_simple(new MyQueueShift(3));
        test_6_add_after_delete(new MyQueueShift(3));

        // LoopQueue
        checkSimpleInsertDelete(new LoopQueue(10));
        checkForOverflow(new LoopQueue(2));
        test_3(new LoopQueue(3));
        test_4(new LoopQueue(5));                         // TODO >> java.lang.ArrayIndexOutOfBoundsException: -1
        test_5_add_after_delete_simple(new LoopQueue(3));
        test_6_add_after_delete(new LoopQueue(3));
    }

    private void test_6_add_after_delete(IQueue iQueue) {
        iQueue.insert(1);
        iQueue.insert(2);
        iQueue.insert(3);
        iQueue.remove();       // [0] == 0
        iQueue.insert(4);
        iQueue.remove();       // [1] == 0
        iQueue.insert(5);
        iQueue.remove();        // [2] == 0
        assertEquals(4, iQueue.peekFront()); // val == 4
        iQueue.insert(6);
        assertEquals(4, iQueue.peekFront()); // == 4
        iQueue.remove();
        iQueue.remove();
        assertEquals(6, iQueue.peekFront());  //  == 6
    }

    private void test_5_add_after_delete_simple(IQueue myQueue) {
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        assertEquals(1, myQueue.remove());
        assertEquals(2, myQueue.remove());
        assertEquals(3, myQueue.remove());

        myQueue.insert(4);
        myQueue.insert(5);
        myQueue.insert(6);
        assertEquals(4, myQueue.remove());
        assertEquals(5, myQueue.remove());
        assertEquals(6, myQueue.remove());

        try {
            myQueue.remove();
            fail();
        } catch (Exception ex) {
            // ignore
        }

        myQueue.insert(7);
        myQueue.insert(8);
        myQueue.insert(9);
        try {
            myQueue.insert(10);
            fail();
        } catch (IllegalArgumentException ex) {
            // ignore
        }
    }

    private void test_4(IQueue queue) {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        assertEquals(1, queue.peekFront());
        queue.remove();
        assertEquals(2, queue.peekFront());
        queue.remove();
        assertEquals(3, queue.peekFront());
        queue.remove();
        assertEquals(4, queue.peekFront());
        queue.remove();
        assertEquals(0, queue.size());
        try {
            queue.remove();
            fail();
        } catch (IllegalArgumentException ex) {
            // ignore
        }
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        try {
            queue.peekFront();
            fail();
        } catch (IllegalArgumentException ex) {
            //ignore
        }
    }

    // limit remove
    private void test_3(IQueue queue) {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.remove();
        queue.remove();
        queue.remove();
        assertEquals(0, queue.size());
        try {
            queue.remove();
            fail();
        } catch (IllegalArgumentException ex) {
            // ignore
        }
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    /**
     * limit insert
     */
    private void checkForOverflow(IQueue queue) {
        queue.insert(1);
        queue.insert(2);
        try {
            queue.insert(3);
            fail();
        } catch (IllegalArgumentException ex) {
            // ignore
        }
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());
    }

    /**
     * Simple insert/remove a new item
     */
    private void checkSimpleInsertDelete(IQueue queue) {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        assertEquals(4, queue.size());
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
        assertEquals(4, queue.remove());
        assertEquals(0, queue.size());
    }
}