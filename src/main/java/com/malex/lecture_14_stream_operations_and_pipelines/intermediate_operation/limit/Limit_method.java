package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.limit;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Limit stream method
 *
 * This is a short-circuiting stateful intermediate operation.
 *
 * Returns a stream consisting of the elements of this stream, truncated to be no longer than
 * maxSize in length. This is a short-circuiting stateful intermediate operation.
 *
 * Params: maxSize – the number of elements the stream should be limited to
 *
 * Returns: the new stream
 *
 * Throws: IllegalArgumentException – if maxSize is negative
 */
public class Limit_method extends AbstractUtils {

  /*
   * Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
   */
  @Test
  public void limit() {
    /*
     * Returns an infinite sequential ordered Stream
     */
    List<Integer> list = Stream.iterate(0, i -> i + 1).peek(this::println).limit(5).toList();
    println("List:", list);
  }
}
