package com.malex.lecture_15_Thread.synchronize.not_thread_save;

import static org.junit.Assert.assertNotEquals;

import com.malex.utils.SampleException;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;

public class MyRunnableSynchronizedByRunMethodWrong extends AbstractObjectValue {

  @Test
  public void runTest() {
    var objectValue = new ObjectValue();
    List<Thread> threads =
        IntStream.range(0, NUMBER_OF_THREADS)
            .mapToObj(i -> new Thread(new MyRunnable(objectValue)))
            .toList();

    threads.forEach(Thread::start);

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

    private final ObjectValue objectValue;

    private MyRunnable(ObjectValue objectValue) {
      this.objectValue = objectValue;
    }

    /** It's the same that synchronized(this) */
    @Override
    public synchronized void run() {
      objectValue.incrementCount();
    }
  }
}
