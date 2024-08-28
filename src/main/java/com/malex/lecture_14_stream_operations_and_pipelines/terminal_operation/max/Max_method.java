package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.max;

import com.malex.utils.AbstractUtils;
import java.util.OptionalInt;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * This is a terminal operation.
 */
public class Max_method extends AbstractUtils {

  @Test
  public void max() {
    OptionalInt maxOpt = Stream.of(-1, 4, 3, 10, -23).mapToInt(i -> i).max();
    maxOpt.ifPresent(this::println);
  }
}
