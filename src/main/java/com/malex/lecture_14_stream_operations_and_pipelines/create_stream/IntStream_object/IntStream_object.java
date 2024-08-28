package com.malex.lecture_14_stream_operations_and_pipelines.create_stream.IntStream_object;

import com.malex.utils.AbstractUtils;
import java.util.stream.IntStream;

/*
 * A sequence of primitive int-valued elements supporting sequential
 * and parallel aggregate operations. This is the int primitive specialization of Stream.
 */
public class IntStream_object extends AbstractUtils {

  public void intStream() {
    IntStream.range(0, 4).forEach(this::println);

    IntStream.of(1, 2, 3).forEach(this::println);

    IntStream build = IntStream.builder().add(1).add(2).build();
  }
}
