package com.malex.lecture_15_concurrency.example_09_interrupt_thread;

import com.malex.lecture_15_concurrency.AbstractThreadSample;

public class InterruptThreadInterrupted extends AbstractThreadSample {

    public static void main(String[] args) {

        var first = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    print("Start processing by first thread -", getCurrentThreadName());
                    Thread.sleep(500);
                    print("End processing by first thread -", getCurrentThreadName());
                } catch (InterruptedException e) {
                    printError(getCurrentThreadName(), "was interrupted , error message:", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });


        var second = new Thread(() -> {
            print("Second thread", getCurrentThreadName(), "interrupt first");
            first.interrupt();
        });

        first.start();
        sleepIgnoreException(1000);
        second.start();
    }
}
