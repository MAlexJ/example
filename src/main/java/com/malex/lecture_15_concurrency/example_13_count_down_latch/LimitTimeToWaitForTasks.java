package com.malex.lecture_15_concurrency.example_13_count_down_latch;

import com.malex.utils.AbstractUtils;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/*
 * Limit time to wait for tasks
 *
 * Diagram:
 *
 * Main Thread      Worker 1                  Worker 2                  Worker 3
 *      |                 |                        |                        |
 *      |----Start------->|                        |---processing---------->|
 *      |----Start------->|---processing---------->|                        |
 *      |----Start------->|                        |<------complete---------|---processing---------->|
 *      |                 |<------complete---------|                        |<------complete---------|
 *      |                 |                        |                        |                        |
 *      |---------------------------countDown()----Await Time Out (3s)-------------------------------|
 *      |                 |-------->Success--------|-------->Success--------|-------->Success--------|
 *      |                                                                                            |
 *      |--------------------------------------OR--Timeout-------------------------------------------|
 *      |                 |-------->Success--------|-------->Fail-----------|-------->Fail-----------|
 *      |                                                                                            |
 *      |------Continue Execution------------------------------------------------------------------->|
 */
public class LimitTimeToWaitForTasks extends AbstractUtils {

  private static final int NUMBER_OF_TASKS = 3;

  private final CountDownLatch latch = new CountDownLatch(NUMBER_OF_TASKS);

  private final Random random = new Random();

  @Test
  public void run() throws InterruptedException {
    for (int i = 1; i <= NUMBER_OF_TASKS; i++) {
      new Thread(
              () -> {
                try {
                  println(Thread.currentThread().getName(), "processing....");
                  sleepInMillis(random.nextInt(400, 1200));
                  println(Thread.currentThread().getName(), "completed....");
                } finally {
                  // Reduce the counter after completion
                  latch.countDown();
                }
              },
              "Task_%s".formatted(i))
          .start();
    }

    println("Main thread is waiting for tasks (no more than 3 seconds)...");

    // We expect all threads to be completed, but not more than 3 seconds
    boolean completed = latch.await(1, TimeUnit.SECONDS);

    // Check if all tasks are completed
    if (completed) {
      println("All tasks are completed on time!");
    } else {
      printError("The waiting time is over! Let’s move on.");
    }
  }
}
