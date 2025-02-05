package com.malex.lecture_15_concurrency.example_13_count_down_latch;

import com.malex.utils.AbstractUtils;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;

public class CountDownLatch_class extends AbstractUtils {

  private static final int NUMBER_OF_TASKS = 3;

  private final CountDownLatch latch = new CountDownLatch(NUMBER_OF_TASKS);

  private final Random random = new Random();

  @Test
  public void run() throws InterruptedException {
    for (int i = 0; i < NUMBER_OF_TASKS; i++) {
      new Thread(
              () -> {
                try {
                  println("Start:", Thread.currentThread().getName());
                  sleepInMillis(10 * random.nextInt(1, 200));
                  println("End:", Thread.currentThread().getName());
                } finally {
                  latch.countDown();
                }
              })
          .start();
    }
    try {
      latch.await();
    } catch (InterruptedException e) {
      printError(e.getMessage());
      Thread.currentThread().interrupt();
    }
    print("Main thread exit", Thread.currentThread().getName());
  }
}
