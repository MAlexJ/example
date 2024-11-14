package com.malex.lecture_15_Thread.thread_pools.shutdown;

import static java.lang.Thread.sleep;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ThreadPoolShutdown extends AbstractUtils {

  @Test
  public void runLongWork() {
    // 1. init pool
    ExecutorService pool = Executors.newSingleThreadExecutor();
    pool.execute(
        () -> {
          try {
            println(
                "...",
                "initiation of long task processing, thread:",
                Thread.currentThread().getName());
            sleep(1000);
            println("...", "end of processing");
          } catch (InterruptedException ex) {
            preparingForPoolCompletion(1000);
          }
        });

    // 2. shutdown pool
    tryToShutdown(pool);

    // 3. retry shutdown pool
    retryShutdownPool(pool);
  }

  @Test
  public void runShortWork() {
    // 1. init pool
    ExecutorService pool = Executors.newSingleThreadExecutor();
    pool.execute(
        () -> {
          try {
            println(
                "...",
                "initiation of long task processing, thread:",
                Thread.currentThread().getName());
            sleep(50);
            println("...", "end of processing, thread:", Thread.currentThread().getName());
          } catch (InterruptedException ex) {
            preparingForPoolCompletion(100);
          }
        });

    // 2. shutdown pool
    tryToShutdown(pool);

    // 3. retry shutdown pool
    retryShutdownPool(pool);
  }

  private void retryShutdownPool(ExecutorService pool) {
    try {
      if (!pool.awaitTermination(60, TimeUnit.MILLISECONDS)) {
        println("Retry shutdown pool, thread:", Thread.currentThread().getName());
        pool.shutdownNow();
        if (!pool.awaitTermination(60, TimeUnit.MILLISECONDS)) {
          println("Pool didn't shutdown!");
        }
      } else {
        println("Poll is closed!");
      }
    } catch (InterruptedException e) {
      println("Exception - pool.shutdownNow()");
      pool.shutdownNow();
    }
  }

  private void tryToShutdown(ExecutorService pool) {
    println("Try to shutdown pool in first, thread:", Thread.currentThread().getName());
    pool.shutdown();
  }

  private void preparingForPoolCompletion(int sleepTimeout) {
    println("Thread:", Thread.currentThread().getName(), "interrupted");
    println("  ...", "before long shutdown:", sleepTimeout);
    sleepInMillisStatic(sleepTimeout);
    println("  ...", "after long shutdown:", sleepTimeout);
  }
}
