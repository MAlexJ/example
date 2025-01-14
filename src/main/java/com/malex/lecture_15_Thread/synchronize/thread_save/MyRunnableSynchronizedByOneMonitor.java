package com.malex.lecture_15_Thread.synchronize.thread_save;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import lombok.Getter;
import org.junit.Test;

/** Synchronization by monitor in Runnable implementation */
public class MyRunnableSynchronizedByOneMonitor extends AbstractUtils {

  private static final int NUMBER_OF_THREADS = 5;
  private static final int NUMBER_OF_LOOP_ITERATIONS = 1_000_000;

  @Test
  public void runTest() {
    // given
    var objectValue = new ObjectValue();
    List<Thread> threads =
        IntStream.range(0, NUMBER_OF_THREADS)
            .mapToObj(iteration -> new Thread(new MyRunnable(objectValue)))
            .toList();

    // when
    threads.forEach(Thread::start);
    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new SampleException(e);
      }
    }

    // then
    int count = objectValue.getCount();
    println("count:", count);
    assertEquals(NUMBER_OF_LOOP_ITERATIONS * NUMBER_OF_THREADS, count);
  }

  private static class MyRunnable implements Runnable {

    private final ObjectValue objectValue;

    MyRunnable(ObjectValue objectValue) {
      this.objectValue = objectValue;
    }

    @Override
    public void run() {
      /** Synchronized by one monitor - ObjectValue */
      synchronized (objectValue) {
        objectValue.incrementCount();
      }
    }
  }

  @Getter
  private static class ObjectValue extends AbstractUtils {
    private int count = 0;

    public void incrementCount() {
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.fillInStackTrace();
      }
      println("Thread start:", Thread.currentThread().getName());
      IntStream.range(0, NUMBER_OF_LOOP_ITERATIONS).forEach(i -> count++);
      println("Thread end:", Thread.currentThread().getName());
    }
  }
}
