package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors_averag_method;

import static junit.framework.TestCase.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class Collectors_averagingDouble_method {

  @Test
  public void averagingDouble() {
    var resultDouble =
        Stream.of(1.0, 2.0, 3.0, 4.0).collect(Collectors.averagingDouble(Double::doubleValue));
    assertEquals(2.5, resultDouble);
  }

  @Test
  public void additional() {
    var resultDouble =
        Stream.of("1.0", "2.0", "3.0", "-4.0")
            .collect(Collectors.averagingDouble(str -> Double.parseDouble(str)));
    assertEquals(0.5, resultDouble);
  }
}
