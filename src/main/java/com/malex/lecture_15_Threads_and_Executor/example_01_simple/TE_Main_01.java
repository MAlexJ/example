package com.malex.lecture_15_Threads_and_Executor.example_01_simple;

import org.apache.log4j.Logger;

public class TE_Main_01 {

  private static final Logger LOG = Logger.getLogger(TE_Main_01.class);

  public static void main(String[] args) {
    Runnable task =
        () -> {
          String threadName = Thread.currentThread().getName();
          LOG.debug("Hello " + threadName);
        };

    // #1
    task.run();

    // #2
    new Thread(task).start();

    // #3
    LOG.debug("Done!");
  }
}
