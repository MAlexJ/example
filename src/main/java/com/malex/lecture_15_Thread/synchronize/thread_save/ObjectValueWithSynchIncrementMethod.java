package com.malex.lecture_15_Thread.synchronize.thread_save;

import com.malex.utils.AbstractUtils;
import lombok.Getter;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

public class ObjectValueWithSynchIncrementMethod extends AbstractUtils {

    private static final int NUMBER_OF_THREADS = 10;
    private static final int NUMBER_OF_LOOP_ITERATIONS = 10_000_000;


    @Test
    public void runTestMethodSynchronized() {
        // given
        var objectValue = new ObjectValue(NUMBER_OF_LOOP_ITERATIONS);

        // when
        runThreads(NUMBER_OF_THREADS, objectValue::incrementCount);

        // then
        println("Count result:", objectValue.getCount());
        assertEquals(NUMBER_OF_LOOP_ITERATIONS * NUMBER_OF_THREADS, objectValue.getCount());
    }

    @Test
    public void runTestSectionSynchronized() {
        // given
        int iterations = NUMBER_OF_LOOP_ITERATIONS * 3;
        int threads = NUMBER_OF_THREADS * 3;
        var objectValue = new ObjectValue(iterations);

        // when
        runThreads(threads, objectValue::incrementCountInsideSynchronized);

        // then
        println("Count result:", objectValue.getCount());
        assertEquals(iterations * threads, objectValue.getCount());
    }


    @SneakyThrows
    private void runThreads(int numberOfThreads, Runnable runnable) {
        // 1. create list of threads with payload
        List<Thread> threads = IntStream.range(0, numberOfThreads).mapToObj(i -> new Thread(runnable)).toList();
        // 2. start all threads
        threads.forEach(Thread::start);
        // 3. Join all threads to main thread.
        for (int i = 0; i < numberOfThreads; i++) {
            // Waits for this thread to terminate.
            threads.get(i).join();
        }
    }


    @Getter
    private static class ObjectValue extends AbstractUtils {
        private int count;
        private final int maxIncrement;

        public ObjectValue(int maxIncrement) {
            this.count = 0;
            this.maxIncrement = maxIncrement;
        }

        /**
         * method synchronized
         */
        public synchronized void incrementCount() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
            println("Thread start:", Thread.currentThread().getName());
            IntStream.range(0, maxIncrement).forEach(i -> count++);
            println("Thread end:", Thread.currentThread().getName());
        }


        /**
         * section synchronized
         */
        public void incrementCountInsideSynchronized() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
            synchronized (this) {
                println("Thread start:", Thread.currentThread().getName());
                IntStream.range(0, maxIncrement).forEach(i -> count++);
                println("Thread end:", Thread.currentThread().getName());
            }
        }
    }
}