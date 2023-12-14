package com.malex.lecture_15_Thread.thread_pools.callable;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadPoolCallable extends AbstractUtils {

    @Test
    public void runCallable() {
        // init
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // impl
        IntStream.range(0, 5).forEach(i -> {
            println(i, ": init");
            Future<String> submit = pool.submit(new MyCallable("MyCallable_" + i));
            while (!submit.isDone()) {
                sleepInMillis(200);
                print(">");
            }
            String result = getFutureResult(submit);
            println(" ", i, ": result:", result);
        });

        // end
        shutdownThreadPoolExecutor(pool);
    }

    private String getFutureResult(Future<String> submit) {
        try {
            return submit.get(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            throw new SampleException(e);
        }
    }

    private static class MyCallable extends AbstractUtils implements Callable<String> {
        private final String name;

        MyCallable(String runName) {
            this.name = runName;
        }

        @Override
        public String call() {
            randomSleepInMillis(1003);
            return String.format("thread: %s, name: %s", Thread.currentThread().getName(), name);
        }
    }

    private void shutdownThreadPoolExecutor(ExecutorService pool) {
        try {
            if (pool.awaitTermination(5, TimeUnit.SECONDS)) {
                println("!", Thread.currentThread().getName(), "await termination");
            }
        } catch (InterruptedException e) {
            Thread thread = Thread.currentThread();
            println(thread.getName(), "interrupted!");
            thread.interrupt();
        }
    }
}
