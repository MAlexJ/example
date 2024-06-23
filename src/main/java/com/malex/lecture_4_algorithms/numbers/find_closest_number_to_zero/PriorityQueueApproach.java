package com.malex.lecture_4_algorithms.numbers.find_closest_number_to_zero;

import java.util.Optional;
import java.util.PriorityQueue;

/**
 * 3. Approach Using Priority Queue
 *
 * <p>An alternative technique involves utilizing a priority queue to efficiently find the closest
 * number to zero without sorting the entire array. It finds the closest number to zero by adding
 * each number to the queue and keeping only the smallest number based on its absolute value.
 */
public class PriorityQueueApproach extends TestImpl {

  @Override
  int findClosestNumberToZero(int[] array) {
    // 1. apply Comparator<? super E> comparator
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Math.abs(b) - Math.abs(a));
    // 2. set limit of element in collection
    int limitOfElement = 1;
    // 3. put all element in queue
    for (int num : array) {
      // inserts the specified element into this priority queue
      queue.offer(num);
      if (queue.size() > limitOfElement) {
        Integer polled = queue.poll();
        print(polled, ",");
      }
    }
    println();
    return Optional.ofNullable(queue.peek()).orElseThrow();
  }
}
