package com.malex.lecture_13_collection_api.array_list;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import org.junit.Test;

/**
 * Causes the 'ConcurrentModificationException' exception when an item is added to the list using
 * the foreach loop
 */
public class AddElementToListUsingForeach_Fail_ConcurrentModificationException
    extends AbstractBase {

  /** java.util.ConcurrentModificationException */
  @Test(expected = ConcurrentModificationException.class)
  public void addElementForeach() {
    // given
    var dogs = new ArrayList<>(PREPARED_DOGS);

    for (var dog : dogs) {
      if (dog.age() < 5) {
        /* java.util.ConcurrentModificationException */
        dogs.add(new Dog(999, "BigGog"));
      }
    }
  }
}
