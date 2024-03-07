package com.malex.lecture_13_collection_api.array_list;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.AssertionFailedError;
import org.junit.Test;

public class RemoveElementFromListUsingFor extends AbstractUtils {

  private final List<Cat> preparedList =
      List.of(
          new Cat(1, "Stephan"),
          new Cat(4, "May"),
          new Cat(6, "Cat"),
          new Cat(9, "Jerry"),
          new Cat(3, "Tom"));

  private record Cat(int age, String name) {}

  /** WTF!! */
  @Test
  public void removeElementUsingFor() {
    // given
    var cats = new ArrayList<>(preparedList);
    assertEquals(5, cats.size());

    for (int i = 0; i < cats.size(); i++) {
      Cat curr = cats.get(i);
      if (curr.age() < 5) {
        cats.remove(curr);
      }
    }

    // Nor remove all by condition
    boolean anyMatch = cats.stream().anyMatch(c -> c.age() < 5);
    assertTrue(anyMatch);
    try {
      assertEquals(2, cats.size());
      fail();
    } catch (AssertionFailedError e) {
      printError("AssertionFailedError exception , error - " + e.getMessage());
    }
  }
}
