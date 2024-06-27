package com.malex.lecture_13_collection_api.queque.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;
import org.junit.Test;

public class QueueInitialization {

  @Test
  public void initialization() {
    Queue<Integer> queue = new LinkedList<>();
    queue = new PriorityQueue<>();
    queue = new ArrayDeque<>();

    // BlockingQueue
    queue = new ArrayBlockingQueue<>(1);
    queue = new LinkedBlockingQueue<>();

    // Concurrent
    queue = new ConcurrentLinkedDeque<>();
    queue = new ConcurrentLinkedQueue<>();

    DelayQueue<Delayed> delayedQueue = new DelayQueue<>();
  }
}
