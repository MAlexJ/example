package com.malex.lecture_15_concurrency.example_08_volatile;

import static com.malex.utils.AbstractUtils.printlnString;

public abstract class VolatileBaseClass extends Thread {

  protected void shutdownThread(String action, long millis) {
    new Thread(
            () -> {
              try {
                Thread.sleep(millis);
              } catch (InterruptedException e) {
                e.fillInStackTrace();
              }
              printlnString(action);
              System.exit(-1);
            })
        .start();
  }

  protected void println(String... str) {
    printlnString(str);
  }
}
