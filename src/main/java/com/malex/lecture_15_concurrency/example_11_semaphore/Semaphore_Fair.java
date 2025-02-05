package com.malex.lecture_15_concurrency.example_11_semaphore;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;
import org.junit.Test;

/*
 * Fair Semaphore (FIFO Order)
 * A fair semaphore ensures that permits are granted in the order they were requested (FIFO).
 */
public class Semaphore_Fair extends AbstractUtils {

  private final ConcurrentLinkedQueue<String> queue;

  private final Semaphore semaphore;

  /*
   * fair – true
   * if this semaphore will guarantee first-in first-out granting of permits under contention, else
   */
  public Semaphore_Fair() {
    semaphore = new Semaphore(1, true); // fair – true
    queue = new ConcurrentLinkedQueue<>();
  }

  @Test
  public void fair() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(10, Thread::new)) {
      IntStream.range(0, 10).forEach(el -> executorService.execute(() -> runJob(el)));
    }

    println("Queue:");
    queue.forEach(el -> println("el:", el));

    assertTrue(queue.poll().contains("[0 - Thread"));
    assertTrue(queue.poll().contains("[1 - Thread"));
    assertTrue(queue.poll().contains("[2 - Thread"));
    assertTrue(queue.poll().contains("[3 - Thread"));
    sleepInMillis(1000);
  }

  private void runJob(int el) {
    try {
      semaphore.acquire();
      println("number: ", el);
      queue.add("[%s - %s]".formatted(el, Thread.currentThread().getName()));
    } catch (InterruptedException e) {
      printErrorStatic(e.toString());
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
  }
}
