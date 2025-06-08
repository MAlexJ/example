package com.malex.lecture_15_concurrency.executor_service.scheduled;

import com.malex.utils.AbstractUtils;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ScheduledExecutorService_example extends AbstractUtils {

  @Test
  public void run() throws InterruptedException {
    Duration interval = Duration.ofSeconds(5);

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    scheduler.scheduleAtFixedRate(
        () -> {
          println("run task: ", System.currentTimeMillis());
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            printlnError(e, 4);
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
          }
          println("end task:");
        },
        0,
        interval.toMillis(),
        TimeUnit.MILLISECONDS);

    TimeUnit.SECONDS.sleep(20);
    scheduler.shutdown();
    println("Scheduler is shutdown");
  }
}
