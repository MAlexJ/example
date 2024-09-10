package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors_to_method;

import com.malex.utils.AbstractUtils;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Returns a Collector that accumulates the input elements into a new Set.
 *
 * There are no guarantees on the type, mutability, serializability, or thread-safety of the Set returned;
 *
 * if more control over the returned Set is required, use toCollection(Supplier).
 */
public class Collectors_toSet_method extends AbstractUtils {

  /*
   * Note: there are no guarantees on the type, mutability, serializability, or thread-safety
   */
  @Test
  public void toSet() {
    Set<String> stringSet = Stream.of("1", "2", "3").collect(Collectors.toSet());
    println("class:", stringSet.getClass().getName());
    println("set:", stringSet);
  }
}
