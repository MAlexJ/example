package com.malex.lecture_13_collection_api.array_list;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.junit.Test;

public class AddElementToListUsingForeach {

  private final List<Dog> preparedList =
      List.of(
          new Dog(1, "Stephan"),
          new Dog(4, "May"),
          new Dog(6, "Cat"),
          new Dog(9, "Jerry"),
          new Dog(3, "Tom"));

  private record Dog(int age, String name) {}

  /** java.util.ConcurrentModificationException */
  @Test(expected = ConcurrentModificationException.class)
  public void addElementForeach() {
    // given
    var dogs = new ArrayList<>(preparedList);
    assertEquals(5, dogs.size());
    // and
    var bigGogdog = new Dog(999, "BigGog");

    for (var dog : dogs) {
      if (dog.age < 5) {
        /** java.util.ConcurrentModificationException */
        dogs.add(bigGogdog);
      }
    }
  }
}
