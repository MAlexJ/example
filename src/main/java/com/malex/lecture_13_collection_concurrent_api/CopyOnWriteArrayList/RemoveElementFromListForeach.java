package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class RemoveElementFromListForeach extends AbstractBase {

  /**
   * Removes the first occurrence of the specified element from this list, if it is present. <br>
   * If this list does not contain the element, it is unchanged.
   */
  @Test
  public void removeElementFromList() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println("cats:", cats, "size:", cats.size());

    // when
    for (var cat : cats) {
      if (cat.equals(PREPARED_CATS.getFirst())) {
        cats.remove(cat);
      }
    }

    // then
    println("cats:", cats, "size:", cats.size());
    assertEquals(PREPARED_CATS.size() - 1, cats.size());
  }
}
