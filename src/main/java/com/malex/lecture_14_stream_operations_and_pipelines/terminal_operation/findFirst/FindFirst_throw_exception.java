package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.findFirst;

import java.util.stream.Stream;
import org.junit.Test;

/*
 * Throws: NullPointerException – if the element selected is null
 */
public class FindFirst_throw_exception {

  @Test(expected = NullPointerException.class)
  public void exception() {
    Stream.of(null, 1, 2, 3).findFirst();
  }
}
