package com.malex.lecture_14_stream_operations_and_pipelines.create_stream.stream;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;

public class Arrays_stream extends AbstractUtils {

  public void stream() {
    int[] array = {-1, 1, 2, 3, 4, 5};
    Arrays.stream(array).forEach(this::println);
  }
}
