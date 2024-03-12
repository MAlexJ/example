package com.malex.lecture_13_collectin_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class AddElementToListForeach extends AbstractBase {

  @Test
  public void addElement() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println(cats);

    // when
    for (var cat : cats) {
      if (cat.equals(PREPARED_CATS.getLast())) {
        cats.add(new Cat(1, "One"));
      }
    }

    // then
    println(cats);
    assertEquals(PREPARED_CATS.size() + 1, cats.size());
  }
}
