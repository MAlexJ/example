package com.malex.lecture_15_Thread.lock.deadlock;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

/**
 * The order of capture of the monitors should be the same for all threads
 */
public class DeadLockUnlockSample extends DeadLockSample {

    @Test
    @SneakyThrows
    public void runUnlockDeadLockSample() {
        Thread thread1 = new Thread(() -> {
            // 1. synchronized by first obj
            synchronized (FIRST_STRING) {
                println(getThreadName(), "in:", FIRST_STRING, getThreadState());

                // 2. sleep 50 ms
                sleepIn50Millis();

                println(getThreadName(), "in:", FIRST_STRING, getThreadState());
                synchronized (SECOND_STRING) {
                    println(">>>", getThreadName(), "in:", SECOND_STRING, getThreadState());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            // 1. synchronized by second obj
            synchronized (FIRST_STRING) {
                println(getThreadName(), "in:", SECOND_STRING, getThreadState());

                // 2. sleep 50 ms
                sleepIn50Millis();

                println(getThreadName(), "in:", SECOND_STRING, getThreadState());
                synchronized (SECOND_STRING) {
                    println(">>>", getThreadName(), "in:", FIRST_STRING, getThreadState());
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        println("End of test");
    }

    @Test
    @SneakyThrows
    public void run10Threads() {
        List<Thread> threads = IntStream.range(0, 10).mapToObj(i -> new Thread(() -> {
            // 1. synchronized by first obj
            synchronized (FIRST_STRING) {
                println(getThreadName(), "in:", FIRST_STRING, getThreadState());

                // 2. sleep 50 ms
                sleepIn50Millis();

                println(getThreadName(), "in:", FIRST_STRING, getThreadState());
                synchronized (SECOND_STRING) {
                    println(">>>", getThreadName(), "in:", SECOND_STRING, getThreadState());
                }
            }
        })).toList();

        threads.forEach(Thread::start);

        for (Thread t : threads) {
            t.join();
        }
        println("End of test");
    }
}