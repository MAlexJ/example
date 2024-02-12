package com.malex.lecture_15_concurrency.example_15_executor_service;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

public class ExecutorServiceApp extends AbstractUtils {

  @Test
  public void run() {
    try (ExecutorService service1 = Executors.newSingleThreadExecutor();
        ExecutorService service2 = Executors.newFixedThreadPool(3);
        ExecutorService service3 = Executors.newScheduledThreadPool(3); ) {

      service1.execute(() -> println("service1"));
      service2.execute(() -> println("service2"));
      service3.execute(() -> println("service3"));
    }
  }
}
