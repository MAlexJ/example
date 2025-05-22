package com.malex.lecture_15_concurrency.executor_service.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import org.junit.Test;

public class ScheduledExecutorService_class {

  @Test
  public void newSingleThreadScheduledExecutor() {
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
  }

  @Test
  public void newSingleThreadScheduledExecutorThreadFactory() {
    ScheduledExecutorService scheduler =
        Executors.newSingleThreadScheduledExecutor(
            new ThreadFactory() {
              @Override
              public Thread newThread(Runnable r) {
                return null;
              }
            });
  }

  @Test
  public void newScheduledThreadPool() {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
  }

  @Test
  public void unconfigurableScheduledExecutorService() {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    ScheduledExecutorService scheduler = Executors.unconfigurableScheduledExecutorService(executor);
  }
}
