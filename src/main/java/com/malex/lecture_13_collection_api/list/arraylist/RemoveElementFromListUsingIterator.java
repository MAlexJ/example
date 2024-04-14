package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;

public class RemoveElementFromListUsingIterator extends AbstractBase {

  /** Removes from the underlying collection the last element returned by this iterator. */
  @Test
  public void iteratorRemoveCurrentElement() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);
    assertEquals(5, cats.size());

    // when
    Iterator<Cat> iterator = cats.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().age() < 5) {
        // Removes from the underlying collection the last element returned by this iterator
        iterator.remove();
      }
    }

    // then
    assertEquals(2, cats.size());
  }
}
