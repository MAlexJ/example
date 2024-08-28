package com.malex.lecture_14_stream_operations_and_pipelines.create_stream.IntStream_object;

import com.malex.utils.AbstractUtils;
import java.util.stream.IntStream;
import org.junit.Test;

public class IntLongDoubleStreamRange extends AbstractUtils {

  @Test
  public void testIntStream() {
    wrapper(
        "Returns sequential ordered IntStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1",
        () -> //
        IntStream.range(-1, 10).forEach(num -> print("num ->", num, " ")));

    wrapper(
        "Returns sequential ordered IntStream from startInclusive (inclusive) to endInclusive (inclusive) by an incremental step of 1",
        () -> //
        IntStream.rangeClosed(0, 5).forEach(num -> print("num ->", num, " ")));

    wrapper(
        "IntStream.of(1, 3, 5, -1, 99)",
        () -> //
        IntStream.of(1, 3, 5, -1, 99).forEach(num -> print("num ->", num, ", ")));

    wrapper(
        "sequential IntStream containing a single element.",
        () -> //
        IntStream.of(1).forEach(num -> print("num ->", num)));

    wrapper(
        "Returns an empty sequential IntStream",
        () -> {
          IntStream empty = IntStream.empty();
          empty.forEach(num -> print("num ->", num));
        });

    wrapper(
        "Builds the stream, transitioning this builder to the built state",
        () -> {
          IntStream intStreamBuild = IntStream.builder().add(1).add(5).add(7).build();
          intStreamBuild.forEach(num -> print("num ->", num, " "));
        });
  }
}
