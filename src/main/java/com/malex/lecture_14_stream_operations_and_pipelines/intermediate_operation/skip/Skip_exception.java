package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.skip;

import java.util.stream.Stream;
import org.junit.Test;

public class Skip_exception {

  @Test(expected = IllegalArgumentException.class)
  public void exception() {
    // given
    int negativeNumber = -1;
    // then
    Stream.of(1, 2, 3).skip(negativeNumber).toList();
  }
}
