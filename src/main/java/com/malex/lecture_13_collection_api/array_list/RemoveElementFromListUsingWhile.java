package com.malex.lecture_13_collection_api.array_list;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class RemoveElementFromListUsingWhile {

  private final List<Cat> preparedList =
      List.of(
          new Cat(1, "Stephan"),
          new Cat(4, "May"),
          new Cat(6, "Cat"),
          new Cat(9, "Jerry"),
          new Cat(3, "Tom"));

  private record Cat(int age, String name) {}

  @Test
  public void removeElementUsingIterator() {
    // given
    var cats = new ArrayList<>(preparedList);
    assertEquals(5, cats.size());

    // when
    Iterator<Cat> iterator = cats.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().age() < 5) {
        iterator.remove();
      }
    }

    // then
    assertEquals(2, cats.size());
  }
}
