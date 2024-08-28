package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.skip;

import static junit.framework.TestCase.assertTrue;

import java.util.stream.Stream;
import org.junit.Test;

public class Skip_more_that_stream {

  @Test
  public void emptyList() {
    // given
    var bigNumber = Integer.MAX_VALUE;

    // when
    var list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).skip(bigNumber).toList();

    // then
    assertTrue(list.isEmpty());
  }
}
