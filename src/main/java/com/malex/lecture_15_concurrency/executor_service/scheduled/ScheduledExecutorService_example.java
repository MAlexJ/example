package com.malex.lecture_15_concurrency.executor_service.scheduled;

import com.malex.utils.AbstractUtils;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ScheduledExecutorService_example extends AbstractUtils {

  public static void main(String[] args) {
    Duration interval = Duration.ofSeconds(2);

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    scheduler.scheduleAtFixedRate(
        () -> {
          printlnString("run task: " + System.currentTimeMillis());
          try {
            TimeUnit.MILLISECONDS.sleep(500);
          } catch (InterruptedException e) {
            printErrorStatic(e.getMessage());
          }
          printlnString("end task:");
        },
        0,
        interval.toMillis(),
        TimeUnit.MILLISECONDS);
  }

  // todo: WTF! run only one time
  @Test
  public void run() {
    Duration interval = Duration.ofSeconds(5);

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    scheduler.scheduleAtFixedRate(
        () -> {
          println("run task: ", System.currentTimeMillis());
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            printlnError(e, 4);
          }
          println("end task:");
        },
        0,
        interval.toMillis(),
        TimeUnit.MILLISECONDS);
  }
}
