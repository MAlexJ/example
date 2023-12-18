package com.malex.lecture_15_Thread.synchronize.not_thread_save;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertNotEquals;

public class MyRunnableSynchronizedByRunMethodWrong extends AbstractObjectValue {

    @Test
    @SneakyThrows
    public void runTest() {
        var objectValue = new ObjectValue();
        List<Thread> threads = IntStream.range(0, NUMBER_OF_THREADS).mapToObj(i -> new Thread(new MyRunnable(objectValue))).toList();

        threads.forEach(Thread::start);

        for (Thread t : threads) {
            t.join();
        }

        // 4. test count
        int count = objectValue.getCount();
        println("count:", count);
        assertNotEquals(TOTAL_INCREMENT_COUNT * NUMBER_OF_THREADS, count);
    }

    private static class MyRunnable implements Runnable {

        private final ObjectValue objectValue;

        private MyRunnable(ObjectValue objectValue) {
            this.objectValue = objectValue;
        }

        /**
         * It's the same that synchronized(this)
         */
        @Override
        public synchronized void run() {
            objectValue.incrementCount();
        }
    }


}