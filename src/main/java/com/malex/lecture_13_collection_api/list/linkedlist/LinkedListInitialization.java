package com.malex.lecture_13_collection_api.list.linkedlist;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import com.malex.utils.AbstractUtils;
import java.util.LinkedList;
import org.junit.Test;

public class LinkedListInitialization extends AbstractUtils {

  @Test
  public void simpleInitialization() {
    LinkedList<String> innerClassInit =
        new LinkedList<>() {
          {
            add("Fist");
            add("Second");
          }
        };

    // when
    String removeFirst = innerClassInit.removeFirst();
    println("Remove first element:", removeFirst);
    println("list:", innerClassInit);

    // then
    assertNotNull(innerClassInit);
    assertEquals(1, innerClassInit.size());
  }
}
