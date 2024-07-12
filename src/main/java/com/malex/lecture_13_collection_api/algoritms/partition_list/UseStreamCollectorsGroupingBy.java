package com.malex.lecture_13_collection_api.algoritms.partition_list;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Split a List into two SubList
 *
 * <p>link:: http://www.techiedelight.com/split-list-two-sublists-java/
 */
public class UseStreamCollectorsGroupingBy extends AbstractUtils {

  private <T> List<List<T>> useCollectorsGroupingBy(List<T> list) {
    if (list.isEmpty()) {
      return List.of();
    }
    int middle = (list.size() - 1) / 2;

    /*
    The classification function maps elements to some key type K. The downstream collector operates on elements of type T and produces a result of type D.
    The resulting collector produces a Map<K, D>.
     */
    Map<Boolean, List<T>> map =
        list.stream()
            .collect(
                Collectors.groupingBy(elem -> list.indexOf(elem) > middle, Collectors.toList()));
    println(map);
    return new ArrayList<>(map.values());
  }

  @Test
  public void test() {
    // test 1: from 1 to 9
    var list = useCollectorsGroupingBy(List.of(1, 2, 3, 4, 5, 6, 7, 8));
    assertEquals(List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8)), list);

    // test 1: from 1 to 9
    list = useCollectorsGroupingBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    assertEquals(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8, 9)), list);

    // test 2: max and min value
    list = useCollectorsGroupingBy(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE));
    assertEquals(List.of(List.of(Integer.MIN_VALUE), List.of(Integer.MAX_VALUE)), list);

    // test 3: empty list
    assertEquals(List.of(), useCollectorsGroupingBy(List.of()));

    // test 4: one element
    assertEquals(List.of(List.of(1)), useCollectorsGroupingBy(List.of(1)));
  }
}
