package com.malex.lecture_15_Thread.example_03_volotile;

import lombok.extern.java.Log;

/**
 * int a; int b;
 * <p>
 * // thread 1:
 * a = 1;
 * b = 2;
 * <p>
 * // thread 2:
 * System.out.print(b);
 * System.out.print(a);
 */
@Log
public class TwoThreadSample {

    int a;
    volatile int b;

    public static void main(String[] args) {
        TwoThreadSample sample = new TwoThreadSample();
        Thread second = sample.startSecond();
        Thread first = sample.startFirst();

        second.start();
        first.start();
    }

    public Thread startFirst() {
        return new Thread(() -> {
            a = 1;
            b = 2;
        });
    }

    public Thread startSecond() {
        return new Thread(() -> {
            log.info("b = " + b);
            log.info("a = " + a);
        });
    }

}
