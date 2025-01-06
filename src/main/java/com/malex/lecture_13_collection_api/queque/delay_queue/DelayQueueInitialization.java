package com.malex.lecture_13_collection_api.queque.delay_queue;

import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestsUtils;
import com.malex.lecture_13_collection_api.TestNameAnnotation;
import com.malex.utils.SampleException;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue examples:
 *
 * <p>link: https://habr.com/ru/articles/599603/
 */
public class DelayQueueInitialization extends AbstractTestsUtils {

  @TestNameAnnotation("All possible implementation of DelayQueue")
  @Override
  public void simpleTest(String description) {
    DelayQueue<DelayEvent> delayQueue = new DelayQueue<>();
    println("DelayQueue created, local time:", LocalTime.now());

    /*
    offer, add - Inserts the specified element into this delay queue.
    */
    boolean added = delayQueue.offer(DelayEvent.createEvent(1000, "Done"));
    println(added);

    /*
    take - retrieves and removes the expired head of this queue, waiting if necessary until an
            expired element is available on this queue.
     */
    while (!delayQueue.isEmpty()) {
      try {
        DelayEvent delayEvent = delayQueue.take();
        println(
            "DelayEvent: " + delayEvent.msg(),
            ", local time:",
            LocalTime.now(),
            ", thread:",
            Thread.currentThread().getName());
      } catch (InterruptedException e) {
        throw new SampleException(e);
      }
    }
  }

  @TestNameAnnotation("Base take or offer methods DelayQueue")
  @Override
  public void baseFunctionalityTest(String description) {
    DelayQueue<DelayEvent> delayQueue = new DelayQueue<>();
    println("DelayQueue created, local time:", LocalTime.now());

    // 1. add - Inserts the specified element into this delay queue.
    assertTrue(delayQueue.add(DelayEvent.createEvent(1000, "1000 ms")));

    // 2. offer - Inserts the specified element into this delay queue.
    assertTrue(delayQueue.offer(DelayEvent.createEvent(2000, "2000 ms")));

    /*
    2. offer
    public boolean offer(E e, long timeout, TimeUnit unit) {
        return offer(e);
    }
    Inserts the specified element into this delay queue. As the queue is unbounded this method will never block.
     */
    assertTrue(delayQueue.offer(DelayEvent.createEvent(3000, "3000ms"), 10, TimeUnit.MILLISECONDS));

    // 4. random
    assertTrue(delayQueue.offer(DelayEvent.createEvent("Random")));

    while (!delayQueue.isEmpty()) {
      try {
        DelayEvent delayEvent = delayQueue.take();
        println(
            "DelayEvent: " + delayEvent.msg(),
            ", local time:",
            LocalTime.now(),
            ", thread:",
            Thread.currentThread().getName());
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new SampleException(e);
      }
    }
  }

  @Override
  public void additionalFunctionalityTest(String description) {
    println("additionalFunctionalityTest, local time:", LocalTime.now());
    DelayQueue<DelayEvent> delayQueue = new DelayQueue<>();

    var write =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                assertTrue(delayQueue.offer(DelayEvent.createEvent("Random" + i)));
              }
            });

    var read =
        new Thread(
            () -> {
              while (!delayQueue.isEmpty()) {
                try {
                  DelayEvent delayEvent = delayQueue.take();
                  println(
                      "DelayEvent: " + delayEvent.msg(),
                      ", local time:",
                      LocalTime.now(),
                      ", thread:",
                      Thread.currentThread().getName());
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                  throw new RuntimeException(e);
                }
              }
            });

    write.start();
    read.start();

    try {
      write.join();
      read.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new SampleException(e);
    }
  }

  record DelayEvent(long startTime, String msg) implements Delayed {

    private static final Random random = new Random();

    static DelayEvent createEvent(int delay, String msg) {
      return new DelayEvent(System.currentTimeMillis() + delay, msg);
    }

    static DelayEvent createEvent(String msg) {
      int nextInt = random.nextInt(1000, 10000);
      return new DelayEvent(System.currentTimeMillis() + nextInt, msg + " - " + nextInt);
    }

    @Override
    public long getDelay(TimeUnit unit) {
      long diff = startTime - System.currentTimeMillis();
      return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed obj) {
      Objects.requireNonNull(obj);
      return Long.compare(this.startTime, ((DelayEvent) obj).startTime);
    }
  }
}
