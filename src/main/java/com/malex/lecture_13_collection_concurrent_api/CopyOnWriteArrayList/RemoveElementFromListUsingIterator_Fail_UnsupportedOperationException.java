package com.malex.lecture_13_collection_concurrent_api.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;

/** Caused 'UnsupportedOperationException' exception when iterator remove element */
public class RemoveElementFromListUsingIterator_Fail_UnsupportedOperationException
    extends AbstractBase {

  /**
   * exception: UnsupportedOperationException
   *
   * <p>Remove element form list using iterator 'iterator.remove()' method
   */
  @Test
  public void iteratorRemoveCurrentElement() {
    // given
    var cats = new CopyOnWriteArrayList<>(PREPARED_CATS);

    // when
    Iterator<Cat> iterator = cats.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().age() < 5) {
        /* remove() >>> java.lang.UnsupportedOperationException */
        iterator.remove();
      }
    }
  }

  /** UnsupportedOperationException */
  @Test(expected = UnsupportedOperationException.class)
  public void removeElementFormIterator() {
    var iterator = new CopyOnWriteArrayList<>(PREPARED_CATS).iterator();
    while (iterator.hasNext()) {
      var cat = iterator.next();
      if (cat.equals(PREPARED_CATS.getLast())) {
        /** UnsupportedOperationException */
        iterator.remove();
      }
    }
  }
}
