package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors_to_method;

import com.malex.utils.AbstractUtils;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/*
 *  <R, A> R collect(Collector<? super T, A, R> collector)
 *
 * This is a terminal operation.
 */
public class Collect_method extends AbstractUtils {

  @Test
  public void collect() {
    var collect = Stream.of(1, 2, 3).collect(Collectors.toList());
    print(collect);
  }
}
