package com.malex.lecture_13_collectin_concurrent_api.CopyOnWriteArrayList;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

public class RemoveElementFromList extends AbstractBase {

  @Test
  public void removeElement() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);
    println("cats:", cats, "size:", cats.size());

    // when

    // then
    println("cats:", cats, "size:", cats.size());
    assertEquals(PREPARED_CATS.size() - 1, cats.size());
  }
}
