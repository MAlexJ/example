package com.malex.lecture_13_collection_api.array_list;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AddElementToListUsingFor {

  private final List<Dog> preparedList =
      List.of(
          new Dog(1, "Stephan"),
          new Dog(4, "May"),
          new Dog(6, "Cat"),
          new Dog(9, "Jerry"),
          new Dog(3, "Tom"));

  private record Dog(int age, String name) {}

  @Test
  public void addElementFor() {
    // given
    var dogs = new ArrayList<>(preparedList);
    assertEquals(5, dogs.size());
    // and
    var dog = new Dog(99999, "BigCat");

    // when
    for (int i = 0; i < dogs.size(); i++) {
      if (dogs.get(i).age() < 5) {
        dogs.add(dog);
      }
    }

    // then
    assertEquals(8, dogs.size());
  }
}
