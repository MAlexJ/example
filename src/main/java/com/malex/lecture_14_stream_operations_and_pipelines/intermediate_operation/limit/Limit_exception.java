package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.limit;

import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class Limit_exception {

  @Test(expected = IllegalArgumentException.class)
  public void exception() {
    // given
    var negativeNumber = -1;

    // then
    List<Integer> list = Stream.iterate(1, i -> i + 1).limit(negativeNumber).toList();
  }
}
