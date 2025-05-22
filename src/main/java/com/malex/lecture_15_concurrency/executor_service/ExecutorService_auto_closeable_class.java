package com.malex.lecture_15_concurrency.executor_service;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

/*
 * An ExecutorService may also be established and closed (shutdown, blocking until terminated) as follows
 */
public class ExecutorService_auto_closeable_class extends AbstractUtils {

  @Test
  public void run() {
    try (ExecutorService executorService = Executors.newCachedThreadPool()) {
      executorService.execute(
          () -> {
            println("Hello World!");
            sleepInMillis(500);
            println("complete!");
          });
      executorService.shutdown();
    }
  }
}
