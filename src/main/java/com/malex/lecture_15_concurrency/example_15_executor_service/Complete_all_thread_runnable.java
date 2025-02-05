package com.malex.lecture_15_concurrency.example_15_executor_service;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.Test;

public class Complete_all_thread_runnable extends AbstractUtils {

  private static final int NUMBER_OF_THREADS = 3;

  private final Random random = new Random();

  @Test
  public void run() throws InterruptedException {
    try (ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {

      List<Runnable> tasks =
          IntStream.range(0, NUMBER_OF_THREADS) //
              .mapToObj(
                  num ->
                      (Runnable)
                          () -> {
                            println("Worker_%s is working...".formatted(num));
                            sleepInMillis(random.nextInt(10, 1000));
                            println("Worker_%s finished.".formatted(num));
                          })
              .toList();

      // Run all tasks
      tasks.forEach(executorService::submit);

      // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new
      // tasks will be accepted.
      executorService.shutdown();

      // Blocks until all tasks have completed execution after a shutdown request
      if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
        printError("Executor did not terminate");
        executorService.shutdownNow();
      }

      println("All workers are done. Main thread continues.");
    }
  }
}
