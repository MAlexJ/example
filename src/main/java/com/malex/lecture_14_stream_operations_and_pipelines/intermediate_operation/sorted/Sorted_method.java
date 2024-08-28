package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.sorted;

import com.malex.utils.AbstractUtils;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Stream<T> sorted();
 *
 * This is a stateful intermediate operation.
 *
 * Returns a stream consisting of the elements of this stream, sorted according to natural order.
 */
public class Sorted_method extends AbstractUtils {

  @Test
  public void sorted() {
    Stream.of(3, -5, 2 - 0).sorted().forEach(this::println);
  }

  @Test
  public void position() {
    // Sorting is a special kind of intermediate operations. These are the so-called state
    // operations.
    Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
        .sorted(
            (s1, s2) -> {
              System.out.printf("sort: %s; %s\n", s1, s2);
              return s1.compareTo(s2);
            })
        .filter(
            s -> {
              System.out.println("filter: " + s);
              return s.startsWith("a");
            })
        .map(
            s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
        .forEach(s -> System.out.println("forEach: " + s));

    System.out.println("\n~~~~~~~~~~~~~~\n");

    Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
        .filter(
            s -> {
              System.out.println("filter: " + s);
              return s.startsWith("a");
            })
        .sorted(
            (s1, s2) -> {
              System.out.printf("sort: %s; %s\n", s1, s2);
              return s1.compareTo(s2);
            })
        .map(
            s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
        .forEach(s -> System.out.println("forEach: " + s));
  }
}
