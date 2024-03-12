package com.malex.lecture_13_collection_api.array_list;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import org.junit.Test;

/**
 * exception: ConcurrentModificationException
 *
 * <p>Remove elements form ArrayList using foreach loop
 *
 * <p>Link to tutorial - <a
 * href="https://javarush.com/groups/posts/1935-udalenie-ehlementa-iz-spiska-arraylist">Remove
 * element form ArrayList</a>
 */
public class RemoveElementFromListUsingForeach_Fail_ConcurrentModificationException
    extends AbstractBase {

  /** ConcurrentModificationException */
  @Test(expected = ConcurrentModificationException.class)
  public void removeItemUsingForeach() {
    // given
    var cats = new ArrayList<>(PREPARED_CATS);

    // iterator exception: java.util.ConcurrentModificationException
    for (var cat : cats) {
      if (cat.age() > 5) cats.remove(cat);
    }
  }
}
