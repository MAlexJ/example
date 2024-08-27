package com.malex.lecture_15_concurrency.example_09_interrupt_thread;

import com.malex.lecture_15_concurrency.AbstractThreadUtils;

import java.util.concurrent.TimeUnit;

public class InterruptThreadIsThreadInterrupted extends AbstractThreadUtils {
    public static void main(String[] args) {
        // #1.
        print("Start", getCurrentThreadName(), "thread ");

        // #2. create first thread
        Thread first = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    print(">>> Start first -", getCurrentThreadName(), "thread");
                    TimeUnit.MILLISECONDS.sleep(400);
                    print(">>> End first -", getCurrentThreadName(), "thread");
                }
            } catch (InterruptedException e) {
                printError("Error message -", e.getMessage(), ", exception class -", e.getClass().getName());
                printError(getCurrentThreadName(), "thread was interrupted!");
            }
        });

        // #3. Create second thread
        Thread second = new Thread(() -> {
            print("Start second -", getCurrentThreadName(), "thread");
            first.interrupt();
        });

        // #4. Run all task with delay - 1000 millis
        first.start();
        sleepIgnoreException(1000);
        second.start();
    }
}