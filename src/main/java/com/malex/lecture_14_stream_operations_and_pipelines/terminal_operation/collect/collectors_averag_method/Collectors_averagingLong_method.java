package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors_averag_method;

import static junit.framework.TestCase.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class Collectors_averagingLong_method {

  @Test
  public void averagingLong() {
    var resultDouble =
        Stream.of(-3L, 3, 3, 3L).collect(Collectors.averagingLong(Number::longValue));
    assertEquals(1.5, resultDouble);
  }
}
