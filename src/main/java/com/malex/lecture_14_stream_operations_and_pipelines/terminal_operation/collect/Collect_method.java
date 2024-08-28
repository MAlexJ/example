package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *  <R, A> R collect(Collector<? super T, A, R> collector)
 *
 * This is a terminal operation.
 */
public class Collect_method {

  public void collect() {
    Set<Integer> collect = Stream.of(1, 2, 3).collect(Collectors.toSet());
  }
}
