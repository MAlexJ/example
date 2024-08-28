package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.findFirst;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/*
* This is a short-circuiting terminal operation.
 */
public class FindFirst_method extends AbstractUtils {

  @Test
  public void findFirst() {
    Optional<String> first = Stream.of("quick", "brown", "fox").findFirst();
    first.ifPresent(this::print);
  }
}
