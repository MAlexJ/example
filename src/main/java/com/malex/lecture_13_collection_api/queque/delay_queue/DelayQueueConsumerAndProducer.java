package com.malex.lecture_13_collection_api.queque.delay_queue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import com.malex.lecture_13_collection_api.TestNameAnnotation;
import com.malex.utils.SampleException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DelayQueue Consumer and Producer
 *
 * <p>In this example, we’ll be looking at the DelayQueue construct from the java.util.concurrent
 * package. This is a blocking queue that could be used in producer-consumer programs.
 *
 * <p>It has a very useful characteristic – when the consumer wants to take an element from the
 * queue, they can take it only when the delay for that particular element has expired.
 *
 * <p>link: https://www.baeldung.com/java-delay-queue#delayqueue-consumer-and-producer
 */
public class DelayQueueConsumerAndProducer extends AbstractTestUtils {

  @TestNameAnnotation("All possible implementation of DelayQueue")
  @Override
  public void test(String description) {
    // 1. create event
    var queue = new DelayQueue<DelayObject>();

    // 2. create producer
    var producer = new DelayQueueProducer(queue, 10, 1000);

    // 3. create consumer
    var consumer = new DelayQueueConsumer(queue);

    // 4. run executor
    ExecutorService executor = Executors.newFixedThreadPool(5);
    executor.submit(producer);
    executor.submit(consumer);
    try {
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      /* Clean up whatever needs to be handled before interrupting  */
      Thread.currentThread().interrupt();
      throw new SampleException(e);
    }
    executor.shutdown();
  }

  static class DelayObject implements Delayed {
    @Getter private String data;

    /**
     * We are defining a startTime – this is a time when the element should be consumed from the
     * queue.
     */
    private long startTime;

    public DelayObject(String data, long delayInMilliseconds) {
      this.data = data;
      this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    /**
     * Therefore, we need to use the TimeUnit.convert() method to return the remaining delay in the
     * proper TimeUnit
     *
     * <p>When the consumer tries to take an element from the queue, the DelayQueue will execute
     * getDelay() to find out if that element is allowed to be returned from the queue. If the
     * getDelay() method will return zero or a negative number, it means that it could be retrieved
     * from the queue.
     */
    @Override
    public long getDelay(TimeUnit unit) {
      long diff = startTime - System.currentTimeMillis();
      printlnString(
          "Asked delay,",
          "diff:",
          Long.toString(diff),
          "thread:",
          Thread.currentThread().getName());
      return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    /**
     * We also need to implement the compareTo() method, because the elements in the DelayQueue will
     * be sorted according to the expiration time. The item that will expire first is kept at the
     * head of the queue and the element with the highest expiration time is kept at the tail of the
     * queue
     */
    @Override
    public int compareTo(@NonNull Delayed obj) {
      return Long.compare(this.startTime, ((DelayObject) obj).startTime);
    }
  }

  @RequiredArgsConstructor
  static class DelayQueueProducer implements Runnable {

    private final Random random = new Random();

    private final DelayQueue<DelayObject> queue;

    /** Number of elements to produce */
    private final Integer elements;

    /** delay of each produced message in milliseconds */
    private final Integer delay;

    @Override
    public void run() {
      for (int i = 0; i < elements; i++) {
        var delayObject = new DelayObject("Json payload_" + UUID.randomUUID(), delay);
        queue.offer(delayObject);
        printlnString("Added delay object, ", "thread:", Thread.currentThread().getName());
        sleepInMillisStatic(random.nextInt(200, 1000));
      }
    }
  }

  @RequiredArgsConstructor
  static class DelayQueueConsumer implements Runnable {

    @Getter private final AtomicInteger counter = new AtomicInteger();

    private final DelayQueue<DelayObject> queue;

    @Override
    public void run() {
      while (true) {
        try {
          printlnString("payload:", queue.take().getData());
          counter.incrementAndGet();
        } catch (InterruptedException e) {
          printErrorStatic("error message:", e.getMessage());
          break;
        }
      }
    }
  }
}
