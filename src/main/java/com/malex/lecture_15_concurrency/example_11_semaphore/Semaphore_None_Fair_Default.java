package com.malex.lecture_15_concurrency.example_11_semaphore;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import org.junit.Test;

/*
 * Non-Fair Semaphore (Default)
 *
 * A non-fair semaphore does not guarantee that threads acquire permits in the order they requested them.
 * Some threads may "jump ahead" if they get CPU time first.
 */
public class Semaphore_None_Fair_Default extends AbstractUtils {

  private static final int THREAD_COUNT = 10;
  private final CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

  private final Semaphore semaphore;
  private final ConcurrentLinkedQueue<String> queue;

  public Semaphore_None_Fair_Default() {
    semaphore = new Semaphore(1);
    queue = new ConcurrentLinkedQueue<>();
  }

  @Test
  public void noneFair() throws InterruptedException {

    for (int i = 0; i < THREAD_COUNT; i++) {
      int temp = i;
      new Thread(
              () -> {
                runJob(temp);
                // Decrements the count of the latch
                latch.countDown();
              })
          .start();
    }

    // Wait for all tasks to finish
    latch.await();

    println("Queue:");
    queue.forEach(el -> println("  el:", el));
  }

  public void runJob(int id) {
    try {
      println(
          "Try to acquire semaphore: " + semaphore.availablePermits(),
          "Thread: ",
          Thread.currentThread().getName());

      // Acquires a permit from this semaphore, blocking until one is available, or the thread is
      // interrupted.
      semaphore.acquire();

      sleepInMillis(200);
      println("complete by id:", id);
      queue.add("[%s - %s]".formatted(id, Thread.currentThread().getName()));
    } catch (InterruptedException e) {
      printErrorStatic(e.toString());
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
  }
}
