package com.malex.lecture_13_collection_api.queque.array_blocking_queue;

import static junit.framework.TestCase.*;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import com.malex.lecture_13_collection_api.TestNameAnnotation;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue class is a bounded blocking queue backed by an array. By bounded, it means
 * that the size of the Queue is fixed. Once created, the capacity cannot be changed. Attempts to
 * put an element into a full queue will result in the operation blocking.
 */
public class ArrayBlockingQueueInitialization extends AbstractTestUtils {

  @TestNameAnnotation("ArrayBlockingQueue initialization")
  @Override
  public void test(String description) {
    Queue<Integer> queue = new ArrayBlockingQueue<>(10);


  }
}
