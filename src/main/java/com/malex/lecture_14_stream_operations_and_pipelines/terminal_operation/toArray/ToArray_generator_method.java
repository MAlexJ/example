package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.toArray;

import com.malex.utils.AbstractUtils;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * <A> A[] toArray( IntFunction<A[]> generator )
 *
 * This is a terminal operation.
 *
 * Params: generator – a function which produces a new array of the desired type and the provided length
 */
public class ToArray_generator_method extends AbstractUtils {

  @Test
  public void toArray() {
    Integer[] array =
        Stream.iterate(1, i -> i + 1) //
            .limit(5)
            .toArray(Integer[]::new);

    println(Arrays.toString(array));
  }
}
