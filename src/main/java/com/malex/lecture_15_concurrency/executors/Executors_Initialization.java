package com.malex.lecture_15_concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.junit.Test;

/*
 * Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory,
 * and Callable classes defined in this package.
 */
public class Executors_Initialization {

  @Test
  public void defaultThreadFactory() {
    Executors.defaultThreadFactory();

    Executors.newCachedThreadPool();
    Executors.newCachedThreadPool(
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
            return new Thread(r);
          }
        });

    Executors.newFixedThreadPool(1);
    Executors.newFixedThreadPool(
        1,
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
            return new Thread(r);
          }
        });

    Executors.newScheduledThreadPool(1);
    Executors.newScheduledThreadPool(
        1,
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
            return null;
          }
        });

    Executors.newSingleThreadExecutor();
    Executors.newSingleThreadExecutor(
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
            return null;
          }
        });

    Executors.newSingleThreadScheduledExecutor();
    Executors.newSingleThreadScheduledExecutor(
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
            return null;
          }
        });

    Executors.newWorkStealingPool();
    Executors.newWorkStealingPool(2);

    Executors.newVirtualThreadPerTaskExecutor();

    Executors.newCachedThreadPool();
    Executors.newCachedThreadPool(
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
            return null;
          }
        });
  }
}
