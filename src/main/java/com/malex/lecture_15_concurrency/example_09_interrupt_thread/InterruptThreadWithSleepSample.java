package com.malex.lecture_15_concurrency.example_09_interrupt_thread;

import com.malex.lecture_15_concurrency.AbstractThreadSample;

public class InterruptThreadWithSleepSample extends AbstractThreadSample {
    public static void main(String[] args) {
        print("Start", getCurrentThreadName(), "thread ");
        Thread first = new Thread(() -> {
            print("Start first -", getCurrentThreadName(), "thread");
        });
        Thread second = new Thread(() -> {
            print("Start second -", getCurrentThreadName(), "thread");
        });

        first.start();
        sleepIgnoreException(200);
        second.start();
    }
}