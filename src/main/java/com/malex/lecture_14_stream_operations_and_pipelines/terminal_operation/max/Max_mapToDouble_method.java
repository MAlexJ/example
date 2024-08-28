package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.max;

import com.malex.utils.AbstractUtils;
import java.util.OptionalDouble;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Returns a DoubleStream consisting of the results of applying
 * the given function to the elements of this stream
 */
public class Max_mapToDouble_method extends AbstractUtils {

  @Test
  public void max() {
    OptionalDouble maxOpt = Stream.of(-1, 4, 3, 10, -23).mapToDouble(i -> i).max();
    maxOpt.ifPresent(this::println);
  }
}
