package com.malex.lecture_13_collection_api.array_list;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;

public class AddElementToListUsingWhile_Fail_ConcurrentModificationException extends AbstractBase {

  /** Exception: java.util.ConcurrentModificationException */
  @Test(expected = java.util.ConcurrentModificationException.class)
  public void addElementUsingIterator() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);

    // when
    Iterator<Dog> iterator = dogs.iterator();
    while (iterator.hasNext()) {
      /** Exception: java.util.ConcurrentModificationException */
      if (iterator.next().age() < 5) {
        var dog = new Dog(99999, "BigCat");
        dogs.add(dog);
      }
    }
  }
}
