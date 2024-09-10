package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors_averag_method;

import static junit.framework.TestCase.assertEquals;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Returns a Collector that produces the arithmetic mean of an integer-valued function applied to the input elements.
 * If no elements are present, the result is 0.
 *
 * Params: mapper – a function extracting the property to be averaged
 *
 * Type parameters: <T> – the type of the input elements
 *
 * Returns: Collector that produces the arithmetic mean of a derived property
 */
public class Collectors_averagingInt_method {

  @Test
  public void averagingInt() {
    var numDouble = Stream.of(1, 2, 3, 4, 5).collect(Collectors.averagingInt(getIntValue()));
    assertEquals(3.0, numDouble);
  }

  @Test
  public void additional() {
    var users =
        List.of(
            new UserRecord("Max", 20), //
            new UserRecord("Alex", 16),
            new UserRecord("Cat", 12));

    var averageDouble = users.stream().collect(Collectors.averagingInt(UserRecord::age));
    assertEquals(16.0, averageDouble);
  }

  /*
  *
   * Represents a function that produces an int-valued result.
   * This is the producing primitive specialization for Function
   *
     @FunctionalInterface
     public interface ToIntFunction<T> {

         int applyAsInt(T value);
      }
   */
  private ToIntFunction<Integer> getIntValue() {
    //  integer -> integer.intValue() or integer -> integer
    return Integer::intValue;
  }

  private record UserRecord(String name, int age) {}
}
