package com.malex.lecture_15_concurrency.example_10_thread_prioriy;

import com.malex.lecture_15_concurrency.AbstractThreadSample;

public class ThreadPriority extends AbstractThreadSample {

    public static void main(String[] args) {
        print(getCurrentThreadName(), " priority - " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        print(getCurrentThreadName(), " priority - " + Thread.currentThread().getPriority());

        var first = new Thread(() -> {
            print(getCurrentThreadName(), " priority - " + Thread.currentThread().getPriority());
        });
        first.setPriority(Thread.MAX_PRIORITY);
        first.start();
        var second = new Thread(() -> {
            print(getCurrentThreadName(), " priority - " + Thread.currentThread().getPriority());
        });

        second.setPriority(Thread.NORM_PRIORITY);
        second.start();
    }
}
