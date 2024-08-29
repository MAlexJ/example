package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.toArray;

import com.malex.utils.AbstractUtils;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * toArray()
 * Returns an array containing the elements of this stream.
 *
 * This is a terminal operation
 *
 * Returns: an array, whose runtime component type is Object, containing the elements of this stream
 */
public class ToArray_method extends AbstractUtils {

  @Test
  public void toArray() {
    Object[] array =
        Stream.iterate(1, i -> i + 1) //
            .limit(5)
            .toArray();

    println(array);
  }
}
