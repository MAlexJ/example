package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors.toMap.mergeFunction_with_mapFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.lecture_13_collection_api.algoritms.joins.ListJoins;
import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

public class KeyMapper_ValueMapper_MergeFunction_MapFactory extends AbstractUtils {

  @Test
  public void testLeftJoinSample() {
    Map<Integer, Integer> joinMap = ListJoins.leftOuterJoin(List.of(1, 2, 3, 4), List.of(4, 5, 6));
    assertNull(joinMap.get(1));
    assertNull(joinMap.get(2));
    assertNull(joinMap.get(3));
    assertEquals(Integer.valueOf(4), joinMap.get(4));
  }

  @Test
  public void test() {
    var first = List.of(1, 2, 3, 4);
    HashMap<Integer, Integer> map =
        first.stream()
            .collect(
                Collectors.toMap(
                    key -> key, // key mapper
                    value -> value, // value mapper
                    (e1, e2) -> {
                      print("e1:", e1);
                      print("e2:", e2);
                      return (e1 + e2) * 100;
                    }, // MergeFunction
                    HashMap::new // map factory
                    ));
    print(map);
  }
}
