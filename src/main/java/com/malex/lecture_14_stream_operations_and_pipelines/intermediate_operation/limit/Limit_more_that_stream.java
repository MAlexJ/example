package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.limit;

import static junit.framework.TestCase.assertEquals;

import java.util.stream.Stream;
import org.junit.Test;

public class Limit_more_that_stream {

  @Test
  public void moreThatStream() {
    var bigNumber = Integer.MAX_VALUE;

    var list = Stream.of(1, 2, 3).limit(bigNumber).toList();
    assertEquals(list.size(), 3);
  }
}
