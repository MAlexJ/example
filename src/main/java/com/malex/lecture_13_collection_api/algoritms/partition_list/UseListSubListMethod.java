package com.malex.lecture_13_collection_api.algoritms.partition_list;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

/**
 * Split a List into two SubList
 *
 * <p>link: <a href="http://www.techiedelight.com/split-list-two-sublists-java/">Split a list into
 * two sublists in Java</a>
 */
public class UseListSubListMethod extends AbstractUtils {

  /**
   * This is recommended approach in Java SE where we use <code>List.subList()</code> method that
   * returns a view of this list between the specified indexes. Since the returned list is backed by
   * this list, we can construct a new List from the returned view
   */
  private <T> List<List<T>> useListSubList(List<T> list) {
    if (list.isEmpty()) {
      return List.of();
    }
    int size = list.size();
    int middle = (size + 1) / 2;
    List<T> first = list.subList(0, middle);
    List<T> second = list.subList(middle, size);
    return List.of(first, second);
  }

  @Test
  public void test() {
    // test 1: from 1 to 9
    var list = useListSubList(List.of(1, 2, 3, 4, 5, 6, 7, 8));
    assertEquals(List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8)), list);

    // test 2: from 1 to 9
    list = useListSubList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    assertEquals(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8, 9)), list);

    // test 3: max and min value
    list = useListSubList(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE));
    assertEquals(List.of(List.of(Integer.MIN_VALUE), List.of(Integer.MAX_VALUE)), list);

    // test 4: empty list
    assertEquals(List.of(), useListSubList(List.of()));

    // test 5: one element
    assertEquals(List.of(List.of(1), List.of()), useListSubList(List.of(1)));

    // test 6: one element
    assertEquals(List.of(List.of(1, 2), List.of(3)), useListSubList(List.of(1, 2, 3)));
  }
}
