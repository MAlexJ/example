package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.mapTo.mapToLong;

import com.malex.utils.AbstractUtils;
import java.util.OptionalLong;
import java.util.stream.Stream;
import org.junit.Test;

public class MapToLong_method extends AbstractUtils {

  @Test
  public void mapToLong() {
    OptionalLong maxOpt = Stream.of(-1, 4, 3, 10, -23).mapToLong(i -> i).max();
    maxOpt.ifPresent(this::println);
  }
}
