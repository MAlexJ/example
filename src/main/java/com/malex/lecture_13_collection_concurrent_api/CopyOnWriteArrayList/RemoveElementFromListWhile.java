package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class RemoveElementFromListWhile extends AbstractBase {

  /** Removes the first occurrence of the specified element from this list, if it is present. */
  @Test
  public void iteratorRemove() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println("cats:", cats, "size:", cats.size());

    // when
    Iterator<Cat> iterator = cats.iterator();
    while (iterator.hasNext()) {
      var cat = iterator.next();
      if (cat.equals(PREPARED_CATS.getFirst())) {
        cats.remove(cat);
      }
    }

    // then
    println("cats:", cats, "size:", cats.size());
    assertEquals(PREPARED_CATS.size() - 1, cats.size());
  }
}
