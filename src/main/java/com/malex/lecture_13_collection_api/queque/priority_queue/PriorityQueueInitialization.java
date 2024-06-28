package com.malex.lecture_13_collection_api.queque.priority_queue;

import com.malex.lecture_13_collection_api.AbstractTestsUtils;
import com.malex.lecture_13_collection_api.TestNameAnnotation;
import java.util.*;

public class PriorityQueueInitialization extends AbstractTestsUtils {

  @TestNameAnnotation("All possible initialization of PriorityQueue")
  @Override
  public void simpleTest(String description) {
    // 1. Default constructor
    Queue<Integer> queue = new PriorityQueue<>();
    println("Queue<Integer> queue = new PriorityQueue<>()", "=", queue);

    // 2. PriorityQueue
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.addAll(List.of(4, 1, -2, 0));
    println("PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>()", "=", priorityQueue);

    // 3.
    PriorityQueue<Integer> priorityQueueWithPriorityQueue = new PriorityQueue<>(priorityQueue);
    println(priorityQueueWithPriorityQueue);
    println("new PriorityQueue<>(priorityQueue)", "=", priorityQueue);

    // 4. Comparator
    Comparator<Integer> reverseOrderComparator = Comparator.reverseOrder();
    PriorityQueue<Integer> priorityQueueWithComparator =
        new PriorityQueue<>(reverseOrderComparator);
    println(priorityQueueWithComparator);

    // 5. SortedSet
    SortedSet<Integer> sortedSet = new TreeSet<>();
    sortedSet.add(1);
    sortedSet.add(-234);
    sortedSet.add(0);
    sortedSet.add(8);
    PriorityQueue<Integer> priorityQueueWithSortedSet = new PriorityQueue<>(sortedSet);
    println(priorityQueueWithSortedSet);
  }

  @Override
  public void baseFunctionalityTest(String description) {}

  @Override
  public void additionalFunctionalityTest(String description) {}
}
