package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.max;

import com.malex.utils.AbstractUtils;
import java.util.OptionalLong;
import java.util.stream.Stream;
import org.junit.Test;

public class Max_mapToLong_method extends AbstractUtils {

  @Test
  public void max() {
    OptionalLong maxOpt = Stream.of(-1, 4, 3, 10, -23).mapToLong(i -> i).max();
    maxOpt.ifPresent(this::println);
  }
}
