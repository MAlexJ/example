package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class RemoveElementFromListFor extends AbstractBase {

  @Test
  public void removeElement() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println("cats:", cats, "size:", cats.size());

    // when
    for (int i = 0; i < cats.size(); i++) {
      if (cats.get(i).equals(PREPARED_CATS.getLast())) {
        cats.remove(i);
      }
    }

    // then
    println("cats:", cats, "size:", cats.size());
    assertEquals(PREPARED_CATS.size() - 1, cats.size());
  }
}
