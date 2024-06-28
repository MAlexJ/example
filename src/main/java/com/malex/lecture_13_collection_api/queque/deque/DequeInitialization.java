package com.malex.lecture_13_collection_api.queque.deque;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeInitialization extends AbstractTestUtils {

  /**
   * A linear collection that supports element insertion and removal at both ends. The name deque is
   * short for "double ended queue" and is usually pronounced "deck". Most Deque implementations
   * place no fixed limits on the number of elements they may contain, but this interface supports
   * capacity-restricted deques as well as those with no fixed size limit
   */
  @Override
  public void test(String description) {
    Deque<String> deque = new ArrayDeque<>();

    deque = new LinkedList<>();

    deque = new ConcurrentLinkedDeque<>();

    deque = new LinkedBlockingDeque<>();
  }
}
