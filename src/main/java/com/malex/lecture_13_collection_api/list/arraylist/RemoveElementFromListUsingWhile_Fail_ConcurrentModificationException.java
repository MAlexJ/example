package com.malex.lecture_13_collection_api.list.arraylist;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import org.junit.Test;

/**
 * Exception: ConcurrentModificationException
 *
 * <p>Remove element from list using list iterator
 */
public class RemoveElementFromListUsingWhile_Fail_ConcurrentModificationException
    extends AbstractBase {

  /**
   * exception: ConcurrentModificationException
   *
   * <p>Removes the first occurrence of the specified element from this list, if it is present.
   */
  @Test(expected = ConcurrentModificationException.class)
  public void removeElementFromList() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);

    // then 'ConcurrentModificationException' exception will throw
    Iterator<Cat> iterator = cats.iterator();
    while (iterator.hasNext()) {
      Cat firstCat = PREPARED_CATS.getFirst();
      /* next >> ConcurrentModificationException */
      Cat nextCat = iterator.next();
      if (nextCat.age() == firstCat.age()) {
        cats.remove(firstCat);
      }
    }
  }
}
