package com.malex.lecture_13_collection_api.algoritms.partition_list;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * We can use <code>Collectors.partitioningBy()</code> to split the list into two sublists in Java 8
 *
 * <p>link: <a href="http://www.techiedelight.com/split-list-two-sublists-java/">Split a list into
 * two sublists in Java</a>
 */
public class UseStreamCollectorsPartitioningBy extends AbstractUtils {

  /*
  The returned Map<Boolean, T> always contains mappings for both false and true keys.
  */
  private <T> List<List<T>> useCollectorsPartitioningBy(List<T> list) {
    // 1. verify input
    var lists = new ArrayList<List<T>>();
    if (list.isEmpty()) {
      return lists;
    }

    // 2. Determine middle of list
    final int midIndex = (list.size() - 1) / 2;

    // 3. Apply partition by
    Map<Boolean, List<T>> map =
        list.stream()
            .collect(
                Collectors.partitioningBy(
                    element -> list.indexOf(element) > midIndex, Collectors.toList()));

    lists.addAll(map.values());
    return lists;
  }

  @Test
  public void test() {
    // test 1: from 1 to 9
    var list = useCollectorsPartitioningBy(List.of(1, 2, 3, 4, 5, 6, 7, 8));
    assertEquals(List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8)), list);

    // test 1: from 1 to 9
    list = useCollectorsPartitioningBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    assertEquals(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8, 9)), list);

    // test 2: max and min value
    list = useCollectorsPartitioningBy(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE));
    assertEquals(List.of(List.of(Integer.MIN_VALUE), List.of(Integer.MAX_VALUE)), list);

    // test 3: empty list
    assertEquals(List.of(), useCollectorsPartitioningBy(List.of()));

    // test 4: one element
    assertEquals(List.of(List.of(1), List.of()), useCollectorsPartitioningBy(List.of(1)));
  }
}
