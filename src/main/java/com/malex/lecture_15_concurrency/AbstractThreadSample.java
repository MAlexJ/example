package com.malex.lecture_15_concurrency;

import java.util.concurrent.TimeUnit;

public class AbstractThreadSample {

    protected static void print(String... logs) {
        System.out.println(String.join(" ", logs));
    }

    protected static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    protected static void sleepIgnoreException(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            String threadName = getCurrentThreadName();
            print(threadName, " was interrupted!");
            throw new RuntimeException(e);
        }
    }
}