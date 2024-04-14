package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.*;

import java.util.ArrayList;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import junit.framework.AssertionFailedError;
import org.junit.Test;

public class RemoveElementFromListUsingFor_NotWell_Records_Skiped extends AbstractBase {

  /** WTF!! */
  @Test
  public void removeElementUsingFor() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
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
