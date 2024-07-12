package com.malex.lecture_13_collection_api.algoritms.partition_list;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Split a List into two SubList
 *
 * <p>link: <a href="http://www.techiedelight.com/split-list-two-sublists-java/">Split a list into
 * two sublists in Java</a>
 */
public class UseLoopToMiddleOfList extends AbstractUtils {

  /**
   * Use 'for' loop from first element to last and additional condition that allow to recognize
   * middle of list
   */
  private <T> List<List<T>> useLoopToMidleOfList(List<T> list) {
    if (list.isEmpty()) {
      return Collections.emptyList();
    }

    // 1. Create empty result list
    var lists = new ArrayList<List<T>>();

    // 2. Create sab lists
    var first = new ArrayList<T>();
    var second = new ArrayList<T>();

    // 3. Determine size of list
    var size = list.size();

    // 4. Go throw all elements of list
    for (int i = 0; i < size; i++) {
      if (i < (size + 1) / 2) {
        first.add(list.get(i));
      } else {
        second.add(list.get(i));
      }
    }

    // 5. Add list
    lists.add(first);
    lists.add(second);
    return lists;
  }

  @Test
  public void test() {
    // test 1: from 1 to 9
    var list = useLoopToMidleOfList(List.of(1, 2, 3, 4, 5, 6, 7, 8));
    assertEquals(List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8)), list);

    // test 1: from 1 to 9
    list = useLoopToMidleOfList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    assertEquals(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8, 9)), list);

    // test 2: max and min value
    list = useLoopToMidleOfList(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE));
    assertEquals(List.of(List.of(Integer.MIN_VALUE), List.of(Integer.MAX_VALUE)), list);

    // test 3: empty list
    assertEquals(List.of(), useLoopToMidleOfList(List.of()));

    // test 4: one element
    assertEquals(List.of(List.of(1), List.of()), useLoopToMidleOfList(List.of(1)));
  }
}
