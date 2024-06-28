package com.malex.lecture_13_collection_api.queque.base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.AbstractTestUtils;
import java.util.LinkedList;
import java.util.Queue;

public class Add extends AbstractTestUtils {
  @Override
  public void test(String description) {
    Queue<String> queue = new LinkedList<>();

    assertTrue(queue.add("1"));
    assertTrue(queue.add("2"));

    assertEquals(2, queue.size());
  }
}
