package com.malex.lecture_13_collection_api.array_list;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class AddElementToListUsingWhile {

  private final List<Dog> preparedList =
      List.of(
          new Dog(1, "Stephan"),
          new Dog(4, "May"),
          new Dog(6, "Cat"),
          new Dog(9, "Jerry"),
          new Dog(3, "Tom"));

  private record Dog(int age, String name) {}

  /** Exception: java.util.ConcurrentModificationException */
  @Test(expected = java.util.ConcurrentModificationException.class)
  public void addElementUsingIterator() {
    // given
    var dogs = new ArrayList<>(preparedList);
    assertEquals(5, dogs.size());
    // and
    var dog = new Dog(99999, "BigCat");

    // when
    Iterator<Dog> iterator = dogs.iterator();
    while (iterator.hasNext()) {
      /** Exception: java.util.ConcurrentModificationException */
      if (iterator.next().age() < 5) {
        dogs.add(dog);
      }
    }

    // then << none
    fail();
  }
}
