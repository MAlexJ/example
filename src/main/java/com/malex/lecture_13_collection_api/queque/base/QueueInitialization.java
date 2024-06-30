package com.malex.lecture_13_collection_api.queque.base;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueInitialization extends AbstractTestUtils {

  @Override
  public void test(String description) {
    Queue<Integer> queue = new LinkedList<>();
    queue = new PriorityQueue<>();
    queue = new ArrayDeque<>();

    // BlockingQueue
    queue = new ArrayBlockingQueue<>(1);
    queue = new LinkedBlockingQueue<>();

    // Concurrent
    queue = new ConcurrentLinkedDeque<>(); // deque
    queue = new ConcurrentLinkedQueue<>(); // queue

    // DelayQueue
    DelayQueue<Delayed> delayedQueue = new DelayQueue<>();
  }
}
