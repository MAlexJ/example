package com.malex.lecture_15_concurrency.example_08_volatile;

import static com.malex.utils.AbstractUtils.sleepInMillisStatic;

import com.malex.utils.SampleException;
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
  public void testThread() {
    // This app will shut down in 5 seconds
    shutdownThread("shut down app!", 5000);

    var thread = new ShareVariableWithoutVolatile();
    thread.start();

    sleepInMillisStatic(100);
    thread.keepRunning = false;

    try {
      thread.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new SampleException(e);
    }
    println("Keep running: " + thread.keepRunning);
  }
}
