package com.malex.lecture_15_concurrency.example_11_semaphore;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.Semaphore;
import org.junit.Test;

public class SemaphoreSample extends AbstractUtils {

  private static final int MAX_PERMITS = 3;
  private static final Semaphore semaphore = new Semaphore(MAX_PERMITS);

  private static final long SIMULATE_SOME_WORK_TIME = 1000;
  private static final int MAIN_THREAD_SLEEP_TIME = 2100;

  @Test
  public void run() {
    for (int i = 1; i <= 10; i++) {
      new Worker("Worker-" + i).start();
    }

    sleepInMillis(MAIN_THREAD_SLEEP_TIME);
  }

  private static class Worker extends Thread {
    private final String name;

    Worker(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      try {
        printlnString(name + " is trying to acquire a permit...");
        semaphore.acquire(); // Acquire a permit
        printlnString(name + " got a permit. Running...");

        // Simulate some work
        Thread.sleep(SIMULATE_SOME_WORK_TIME);

        printlnString(name + " is releasing the permit.");
        semaphore.release(); // Release the permit
      } catch (InterruptedException e) {
        printErrorStatic(e.toString());
        Thread.currentThread().interrupt();
      }
    }
  }
}
