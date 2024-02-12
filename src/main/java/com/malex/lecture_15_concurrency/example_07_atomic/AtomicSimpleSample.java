package com.malex.lecture_15_concurrency.example_07_atomic;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/** Tutorial: <a href="https://www.youtube.com/watch?v=Da57gcGWcCM">Easy Java - Lesson 17</a> */
public class AtomicSimpleSample extends AbstractUtils {

  @Test
  public void run() {
    // given
    var counter = new Counter();

    // when
    var first =
        new Thread(
            () -> {
              for (int i = 0; i < 100000 / 2; i++) {
                counter.increment();
              }
            });

    var second =
        new Thread(
            () -> {
              for (int i = 0; i < 100000 / 2; i++) {
                counter.increment();
              }
            });

    var third =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) {
                counter.decrement();
              }
            });

    // then
    startAllThreadAndJoinMain(first, second, third);

    // and
    int count = counter.getCount();
    printlnString("count = " + count);
    assertEquals(0, counter.getCount());
  }

  private void startAllThreadAndJoinMain(Thread... threads) {
    Arrays.stream(threads)
        .forEach(
            thread -> {
              thread.start();
              try {
                thread.join();
              } catch (InterruptedException e) {
                fail();
              }
            });
  }

  private static class Counter {

    private final AtomicInteger atomicInteger;

    public Counter() {
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
}
