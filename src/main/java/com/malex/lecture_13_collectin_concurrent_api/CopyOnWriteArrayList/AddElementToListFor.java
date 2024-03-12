package com.malex.lecture_13_collectin_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class AddElementToListFor extends AbstractBase {

  @Test
  public void addElement() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println("cats:", cats, "size:", cats.size());

    // when
    int count = 0;
    for (int i = 0; i < cats.size(); i++) {
      if (cats.get(i).equals(PREPARED_CATS.getFirst())) {
        cats.add(new Cat(1, "One"));
      }
      count++;
    }

    // then
    println("cats:", cats, "size:", cats.size(), "count:", count);
    assertEquals(PREPARED_CATS.size() + 1, cats.size());
    assertEquals(PREPARED_CATS.size() + 1, count);
  }
}
