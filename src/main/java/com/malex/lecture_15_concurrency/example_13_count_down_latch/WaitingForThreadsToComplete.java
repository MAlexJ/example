package com.malex.lecture_15_concurrency.example_13_count_down_latch;

import com.malex.utils.AbstractUtils;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/*
 * Waiting for threads to complete
 *
 * Description: "The main thread waits for other threads to finish before continuing execution."
 * Process:
 *    - "Main thread creates worker threads."
 *    - "Each worker thread starts its work independently."
 *    - "Worker threads finish work at different times and call countDown()."
 *    - "Main thread is blocked at await() until count reaches zero."
 *    - "Once all workers finish, the main thread continues execution."
 *
 * Diagram:
 *    Main Thread      Worker 1                 Worker 2                Worker 3
 *       |                |                       |                       |
 *       |------Start---->|                       |                       |
 *       |                |----Start------------->|                       |
 *       |                |                       |------Start----------->|
 *       |                |  Doing Work           |                       |
 *       |                |  Finishing            |                       |
 *       |                |<-----countDown()------|                       |
 *       |                |                       |<-----countDown()------|
 *       |                |                       |                       |------countDown()----->|
 *       |---await()----->|                       |                       |                       |
 *       |  (Blocked)     |                       |                       |                       |
 *       |  (Waiting)     |                       |                       |                       |
 *       |  (All done)    |                       |                       |                       |
 *       |------Continue Execution--------------------------------------------------------------->|
 */
public class WaitingForThreadsToComplete extends AbstractUtils {

  private static final int NUMBER_OF_THREADS = 3;

  private final CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);

  private final Random random = new Random();

  @Test
  public void run() throws InterruptedException {
    for (int i = 1; i <= NUMBER_OF_THREADS; i++) {
      new Thread(
              () -> {
                try {
                  println(Thread.currentThread().getName(), "processing...");
                  sleepInMillis(random.nextInt(1, 500));
                  println(Thread.currentThread().getName(), "complete");
                } catch (Exception e) {
                  printlnError(e, 3);
                  Thread.currentThread().interrupt();
                } finally {
                  // Decrements the count of the latch
                  latch.countDown();
                }
              },
              "thread " + i)
          .start();
    }

    println("Main thread is waiting for other threads to finish...");
    // Waiting for all threads to complete
    latch.await();
    println("All threads are finished. The main thread continues.");
  }
}
