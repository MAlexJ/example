package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** Initialization ArrayList */
public class ArrayListInitialization extends AbstractUtils {

  @Test
  public void initializationModifiedLists() {
    // given
    List<String> innerClassInit =
        new ArrayList<>() {
          {
            add("First task");
            add("Second task");
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
