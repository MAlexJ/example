package com.malex.lecture_15_Thread.thread_pools.runnable;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPoolRunnable extends AbstractUtils {
    
    @Test
    public void runRunnable() {
        try (ExecutorService pool = Executors.newFixedThreadPool(2)) {
            // impl
            IntStream.range(0, 5).forEach(iteration -> {
                println(iteration, ":  thread:", Thread.currentThread().getName(), "running MyRunnable class");
                pool.execute(new MyRunnable(iteration));
            });
        }
    }

    private static class MyRunnable extends AbstractUtils implements Runnable {

        private final int iteration;

        MyRunnable(int iteration) {
            this.iteration = iteration;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            println("  >", iteration, ": starting in thread:", threadName);
            randomSleepInMillis(200);
            println("  <", iteration, ": end of work in thread:", threadName);
        }
    }
}
