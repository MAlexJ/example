package com.malex.lecture_26_SDL.evicting_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvictingQueue<E> {

  private final Queue<E> queue;
  final int maxSize;

  private EvictingQueue(int maxSize) {
    if (maxSize <= 0) {
      throw new IllegalArgumentException("Max size must be greater than 0");
    }
    this.maxSize = maxSize;
    this.queue = new LinkedList<>();
  }

  public static <E> EvictingQueue<E> create(int maxSize) {
    return new EvictingQueue<>(maxSize);
  }

  public boolean offer(E e) {
    return this.add(e);
  }

  // Retrieve but do not remove the head of the queue
  public E peek() {
    return queue.peek();
  }

  // Retrieve and remove the head of the queue
  public E poll() {
    return queue.poll();
  }

  // Get the current size of the queue
  public int size() {
    return queue.size();
  }

  // Check if the queue is empty
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public String toString() {
    return queue.toString();
  }

  /*
   * Add an element to the queue, evicting the oldest if necessary
   */
  public boolean add(E element) {
    if (queue.size() == maxSize) {
      queue.poll(); // Remove the oldest element
    }
    return queue.offer(element);
  }

  public List<E> toList() {
    return queue.stream().toList();
  }
}
