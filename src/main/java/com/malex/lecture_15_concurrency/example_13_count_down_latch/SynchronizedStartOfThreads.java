package com.malex.lecture_15_concurrency.example_13_count_down_latch;

import com.malex.utils.AbstractUtils;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/*
 * Synchronized start of threads
 *
 * Description: "All worker threads start execution at the same time after receiving a signal."
 * Process:
 *   - "Main thread creates worker threads."
 *   - "Workers are started but block at await(), waiting for the start signal."
 *   - "Main thread performs some preparation work."
 *   - "Once ready, the main thread calls countDown() to release all worker threads simultaneously."
 *   - "Workers begin execution at the same moment."
 *
 * Diagram:
 *
 *  Main Thread      Worker 1                  Worker 2                  Worker 3
 *     |                 |
 *     |------Start----->|
 *     |                 |---Preparation--------->|
 *     |                 |---Waiting (await())--->|---Preparation--------->|
 *     |                 |                        |---Waiting (await())--->|---Preparation--------->|
 *     |                 |                        |                        |---Waiting (await())--->|
 *     |                 |                        |                        |                        |
 *     |---countDown()-->|                        |                        |                        |
 *     |---Start Work------------------------------------------------------------------------------>|
 *     |                 |                        |                        |                        |
 *     |                 |   Doing Work           |   Doing Work           |   Doing Work           |
 *     |                 |                        |                        |                        |
 *     |-------------------Continue Execution------------------------------------------------------>|
 */
public class SynchronizedStartOfThreads extends AbstractUtils {

  private static final int ONLY_ONE = 1;

  private final CountDownLatch startSignal = new CountDownLatch(ONLY_ONE);

  private final Random random = new Random();

  @Test
  public void run() throws InterruptedException {
    int numberOfWorkers = 5;
    for (int i = 1; i <= numberOfWorkers; i++) {
      new Thread(
              () -> {
                try {
                  sleepInMillis(random.nextInt(100, 1000));
                  println(Thread.currentThread().getName(), "is ready to work...");

                  // Wait until the signal is given
                  startSignal.await();

                  println(Thread.currentThread().getName(), "started working!");
                } catch (InterruptedException e) {
                  printError(e.getMessage());
                  Thread.currentThread().interrupt();
                }
              },
              "Worker_" + i)
          .start();
    }

    // Simulate preparation time
    Thread.sleep(2000);

    println("Main thread is giving the start signal!");

    // Signal all threads to start working
    startSignal.countDown();
  }
}
