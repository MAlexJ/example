package com.malex.lecture_15_Thread.synchronize.not_thread_save;

import static org.junit.Assert.assertNotEquals;

import com.malex.utils.SampleException;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;

/** Synchronization by this link in Runnable implementation */
public class MyRunnableSynchronizedByThisWrong extends AbstractObjectValue {

  @Test
  public void runTest() {
    // 1. init
    var objectValue = new ObjectValue();
    List<Thread> threads =
        IntStream.range(0, NUMBER_OF_THREADS) //
            .mapToObj(iteration -> new Thread(new MyRunnable(objectValue))) //
            .toList();

    // 2. start all threads
    threads.forEach(Thread::start);

    // 3. wait all threads in main
    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new SampleException(e);
      }
    }

    // 4. test count
    int count = objectValue.getCount();
    println("count:", count);
    assertNotEquals(TOTAL_INCREMENT_COUNT * NUMBER_OF_THREADS, count);
  }

  private static class MyRunnable implements Runnable {

    @Override
    public void run() {
      /** Note: Wrong synchronization! Synchronization by this object */
      synchronized (this) {
        objectValue.incrementCount();
      }
    }

    private final ObjectValue objectValue;

    MyRunnable(ObjectValue objectValue) {
      this.objectValue = objectValue;
    }
  }
}
