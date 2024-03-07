package com.malex.lecture_13_collection_api.array_list;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.junit.Test;

/**
 * Remove elements form ArrayList using foreach loop
 *
 * <p>Link to tutorial - <a
 * href="https://javarush.com/groups/posts/1935-udalenie-ehlementa-iz-spiska-arraylist">Remove
 * element form ArrayList</a>
 */
public class RemoveElementFromListUsingForeach extends AbstractUtils {

  private final List<Cat> preparedList =
      List.of(
          new Cat(1, "Stephan"),
          new Cat(4, "May"),
          new Cat(6, "Cat"),
          new Cat(9, "Jerry"),
          new Cat(3, "Tom"));

  private record Cat(int age, String name) {}

  /** ConcurrentModificationException */
  @Test
  public void removeItemUsingForeach() {
    // given
    var cats = new ArrayList<>(preparedList);
    assertEquals(5, cats.size());

    // when
    try {
      for (var cat : cats) {
        if (cat.age() > 5) cats.remove(cat);
      }
      fail();
    } catch (ConcurrentModificationException e) {
      printlnError(e, 3);
    }
  }
}
