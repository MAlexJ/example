package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors.toMap;

import com.malex.utils.AbstractUtils;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class Collectors_toMap_method extends AbstractUtils {

  @Test
  public void toMap() {
    Map<Integer, Integer> map =
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toMap(k -> k, v -> v));

    println("class:", map.getClass().getName());
    println("map:", map);
  }
}
