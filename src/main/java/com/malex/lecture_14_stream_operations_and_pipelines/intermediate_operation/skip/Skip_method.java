package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.skip;

import com.malex.utils.AbstractUtils;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Skip stream method
 *
 * This is a stateful intermediate operation.
 *
 * Returns a stream consisting of the remaining elements of this stream
 * after discarding the first n elements of the stream.
 * If this stream contains fewer than n elements then an empty stream will be returned.
 * This is a stateful intermediate operation.
 *
 *
 * Params: n – the number of leading elements to skip
 *
 * Returns: the new stream
 *
 * Throws:  IllegalArgumentException – if n is negative
 */
public class Skip_method extends AbstractUtils {

  @Test
  public void skip() {
    var list =
        Stream.of(1, 2, 3, 4, 5, 6, 7) //
            .skip(3)
            .peek(this::println)
            .toList();

    println("list:", list);
  }
}
