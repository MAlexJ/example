package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.filter;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

/*
 * This is an intermediate operation
 *
 * Returns a stream consisting of the elements of this stream that match the given predicate.
 */
public class Filter_method extends AbstractUtils {

  private static final List<String> LIST =
      List.of("Paris", "London", "Madrid", "Berlin", "Brussels");

  @Test
  public void test() {
    Predicate<String> predicate = city -> city.length() > 6;

    var cities = LIST.stream().filter(predicate).toList();

    println("Cities: " + cities);
  }
}
