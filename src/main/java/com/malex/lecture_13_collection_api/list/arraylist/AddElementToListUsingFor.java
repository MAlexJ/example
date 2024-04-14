package com.malex.lecture_13_collection_api.list.arraylist;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import org.junit.Test;

public class AddElementToListUsingFor extends AbstractBase {

  @Test
  public void addElementFor() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);
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
