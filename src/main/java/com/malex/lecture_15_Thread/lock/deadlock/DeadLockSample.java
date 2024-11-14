package com.malex.lecture_15_Thread.lock.deadlock;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import org.junit.Test;

public class DeadLockSample extends AbstractUtils {

  protected static final String FIRST_STRING = "first";
  protected static final String SECOND_STRING = "second";

  @Test
  public void runDeadLockSample() {
    Thread thread1 =
        new Thread(
            () -> {
              // 1. synchronized by first obj
              synchronized (FIRST_STRING) {
                println(getThreadName(), "in:", FIRST_STRING, getThreadState());

                // 2. sleep 50 ms
                sleepInMillisStatic(50);

                println(getThreadName(), "in:", FIRST_STRING, getThreadState());
                synchronized (SECOND_STRING) {
                  println(">>>", getThreadName(), "in:", SECOND_STRING, getThreadState());
                }
              }
            });

    Thread thread2 =
        new Thread(
            () -> {
              // 1. synchronized by second obj
              synchronized (SECOND_STRING) {
                println(getThreadName(), "in:", SECOND_STRING, getThreadState());

                // 2. sleep 50 ms
                sleepInMillisStatic(50);

                println(getThreadName(), "in:", SECOND_STRING, getThreadState());
                synchronized (FIRST_STRING) {
                  println(">>>", getThreadName(), "in:", FIRST_STRING, getThreadState());
                }
              }
            });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new SampleException(e);
    }
    println("End of test");
  }

  protected String getThreadName() {
    return "Thread: " + Thread.currentThread().getName();
  }

  protected String getThreadState() {
    return "status: " + Thread.currentThread().getState();
  }
}
