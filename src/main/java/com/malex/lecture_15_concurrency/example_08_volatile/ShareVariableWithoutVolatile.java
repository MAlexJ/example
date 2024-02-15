package com.malex.lecture_15_concurrency.example_08_volatile;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.Test;

/** Share variable without volatile */
public class ShareVariableWithoutVolatile extends VolatileBaseClass {
  private boolean keepRunning = true;

  @Override
  public void run() {
    long count = 0;
    while (keepRunning) {
      count++;
    }
    println("Thread terminated:", Thread.currentThread().getName(), ", count:" + count);
  }

  @Test
  @SneakyThrows
  public void testThread() {
    // This app will shut down in 5 seconds
    shutdownThread("shut down app!", 5000);

    var thread = new ShareVariableWithoutVolatile();
    thread.start();

    TimeUnit.MILLISECONDS.sleep(100);
    thread.keepRunning = false;

    thread.join();
    println("Keep running: " + thread.keepRunning);
  }
}
