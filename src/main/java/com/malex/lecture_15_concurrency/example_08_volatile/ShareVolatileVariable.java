package com.malex.lecture_15_concurrency.example_08_volatile;

import static com.malex.utils.AbstractUtils.printlnString;
import static com.malex.utils.AbstractUtils.sleepInMillisStatic;

import com.malex.utils.SampleException;
import org.junit.Test;

public class ShareVolatileVariable extends VolatileBaseClass {

  private volatile boolean volatileKeepRunning = true;

  @Override
  public void run() {
    long count = 0;
    while (volatileKeepRunning) {
      count++;
    }
    println("Thread terminated:", Thread.currentThread().getName(), ", count:" + count);
  }

  @Test
  public void volatileSharedVariable() {
    var thread = new ShareVolatileVariable();
    thread.start();

    sleepInMillisStatic(1000);
    thread.volatileKeepRunning = false;

    try {
      thread.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new SampleException(e);
    }
    printlnString("Keep running: " + thread.volatileKeepRunning);
  }
}
