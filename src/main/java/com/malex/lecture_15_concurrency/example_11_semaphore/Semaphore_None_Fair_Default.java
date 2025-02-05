package com.malex.lecture_15_concurrency.example_11_semaphore;

import com.malex.utils.AbstractUtils;
import java.time.Duration;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/*
 * Non-Fair Semaphore (Default)
 *
 * A non-fair semaphore does not guarantee that threads acquire permits in the order they requested them.
 * Some threads may "jump ahead" if they get CPU time first.
 */
public class Semaphore_None_Fair_Default extends AbstractUtils {

  private final Semaphore semaphore;
  private final ConcurrentLinkedQueue<String> queue;

  public Semaphore_None_Fair_Default() {
    semaphore = new Semaphore(1);
    queue = new ConcurrentLinkedQueue<>();
  }

  @Test
  public void noneFair() throws InterruptedException {
    int threadCount = 10;
    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
//    CountDownLatch_class latch = new CountDownLatch_class(threadCount);

    for (int i = 0; i < threadCount; i++) {
      int temp = i;
      executorService.submit(() -> {
        runJob(temp);
//        latch.countDown(); // Signal completion
      });
    }

    println("Queue:");
    queue.forEach(el -> println("el:", el));

//    latch.await(); // Wait for all tasks to finish
    executorService.shutdown();
    executorService.awaitTermination(5, TimeUnit.SECONDS);
  }

  public void runJob(int id) {
    try {
      println(
          "Try to acquire semaphore: " + semaphore.availablePermits(),
          "Thread: ",
          Thread.currentThread().getName());
      semaphore.acquire();
      println("id:", id);
      queue.add("[%s - %s]".formatted(id, Thread.currentThread().getName()));
    } catch (InterruptedException e) {
      printErrorStatic(e.toString());
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
  }
}
