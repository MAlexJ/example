package com.malex.lecture_15_Thread.synchronize.not_thread_save;

import com.malex.utils.AbstractUtils;
import lombok.Getter;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AbstractObjectValue extends AbstractUtils {

    /**
     * Number of thead that are created in loop
     */
    protected static final int NUMBER_OF_THREADS = 3;

    /**
     * When the method is started, the value of the variable increases to the specified value
     */
    protected static final int TOTAL_INCREMENT_COUNT = 100_000;

    @Getter
    protected static class ObjectValue extends AbstractUtils {
        private int count = 0;

        protected void incrementCount() {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
            println("Thread start:", Thread.currentThread().getName());
            IntStream.range(0, TOTAL_INCREMENT_COUNT).forEach(i -> count++);
            println("Thread end:", Thread.currentThread().getName());
        }
    }
}