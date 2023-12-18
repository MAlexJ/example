package com.malex.lecture_15_Thread.lock.deadlock;

import com.malex.utils.AbstractUtils;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class DeadLockSample extends AbstractUtils {

    protected static final String FIRST_STRING = "first";
    protected static final String SECOND_STRING = "second";

    @Test
    @SneakyThrows
    public void runDeadLockSample() {
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
            synchronized (SECOND_STRING) {
                println(getThreadName(), "in:", SECOND_STRING, getThreadState());

                // 2. sleep 50 ms
                sleepIn50Millis();

                println(getThreadName(), "in:", SECOND_STRING, getThreadState());
                synchronized (FIRST_STRING) {
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

    @SneakyThrows
    protected void sleepIn50Millis() {
        TimeUnit.MILLISECONDS.sleep(50);
    }

    protected String getThreadName() {
        return "Thread: " + Thread.currentThread().getName();
    }

    protected String getThreadState() {
        return "status: " + Thread.currentThread().getState();
    }
}
