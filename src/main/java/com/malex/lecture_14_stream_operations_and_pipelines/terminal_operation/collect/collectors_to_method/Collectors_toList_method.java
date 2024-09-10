package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors_to_method;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Returns a Collector that accumulates the input elements into a new List.
 *
 * There are no guarantees on the type, mutability, serializability, or thread-safety of the List returned;
 *
 * if more control over the returned List is required, use toCollection(Supplier).
 */
public class Collectors_toList_method extends AbstractUtils {

  /*
   * Note: there are no guarantees on the type, mutability, serializability, or thread-safety
   */
  @Test
  public void toList() {
    List<String> stringList = Stream.of("1", "2", "3").collect(Collectors.toList());
    println("class:", stringList.getClass().getName());
    println("list:", stringList);
  }

  /*
   * The returned List is unmodifiable;
   * calls to any mutator method will always cause UnsupportedOperationException to be thrown.
   */
  @Test
  public void instanceOfCollectorsToList() {
    List<String> list = Stream.of("1", "2", "3").toList();
    // ImmutableCollections
    println("class:", list.getClass().getName());
    println("list:", list);
  }
}
