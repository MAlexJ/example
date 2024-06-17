package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class AddElementToListWhile extends AbstractBase {

  /** Appends the specified element to the end of this list. */
  @Test
  public void addElement() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println(cats);

    // when
    Iterator<Cat> iterator = cats.iterator();
    while (iterator.hasNext()) {
      var next = iterator.next();
      if (next.equals(PREPARED_CATS.getFirst())) {
        // Appends the specified element to the end of this list.
        cats.add(new Cat(1, "One"));
      }
    }

    // then
    println(cats);
    assertEquals(PREPARED_CATS.size() + 1, cats.size());
  }
}
