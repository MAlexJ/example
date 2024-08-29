package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.map;

import java.util.List;
import org.junit.Test;

/*
 * Returns a stream consisting of the results of applying the given function to the elements of this stream.
 * This is an intermediate operation
 *
 * Params: mapper – a non-interfering, stateless function to apply to each element
 *
 * Returns: the new stream
 */
public class Map_method {
  @Test
  public void map() {

    List<String> strings = List.of(1, 2, 3).stream().map(num -> num.toString()).toList();
  }
}
