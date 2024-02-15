package com.malex.lecture_15_concurrency.example_08_volatile;

import static com.malex.utils.AbstractUtils.printlnString;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
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
  @SneakyThrows
  public void volatileSharedVariable() {
    var thread = new ShareVolatileVariable();
    thread.start();

    TimeUnit.MILLISECONDS.sleep(1000);
    thread.volatileKeepRunning = false;

    thread.join();
    printlnString("Keep running: " + thread.volatileKeepRunning);
  }
}
