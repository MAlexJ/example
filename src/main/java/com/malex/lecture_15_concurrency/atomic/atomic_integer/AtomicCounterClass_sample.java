package com.malex.lecture_15_concurrency.atomic.atomic_integer;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_15_concurrency.AbstractThreadUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/** Tutorial: <a href="https://www.youtube.com/watch?v=Da57gcGWcCM">Easy Java - Lesson 17</a> */
public class AtomicCounterClass_sample extends AbstractThreadUtils {

  private static class AtomicCounter {

    private final AtomicInteger atomicInteger;

    public AtomicCounter() {
      this.atomicInteger = new AtomicInteger();
    }

    public void increment() {
      this.atomicInteger.incrementAndGet();
    }

    public void decrement() {
      this.atomicInteger.decrementAndGet();
    }

    public int getCount() {
      return this.atomicInteger.get();
    }
  }

  @Test
  public void testCount() {
    // given
    var counter = new AtomicCounter();
    var value = 100_000;

    // when
    var firstIncrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < value / 2; i++) {
                counter.increment();
              }
            });

    var secondIncrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < value / 2; i++) {
                counter.increment();
              }
            });

    var decrementThread =
        new Thread(
            () -> {
              for (int i = 0; i < value; i++) {
                counter.decrement();
              }
            });

    // then
    startAllThread(firstIncrementThread, secondIncrementThread, decrementThread);
    joinAllThreadToMain(firstIncrementThread, secondIncrementThread, decrementThread);

    // and
    int count = counter.getCount();
    print("count = " + count);
    assertEquals(0, counter.getCount());
  }
}
