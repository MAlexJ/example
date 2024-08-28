package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.min;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * min(...) - describing the minimum element of this stream, or an empty optional if this stream is empty
 *
 * This is a terminal operation.
 *
 */
public class Min_mapToInt_method extends AbstractUtils {

  /*
   * OptionalInt min()
   *
   * Returns an OptionalInt describing the minimum element of this stream,
   * or an empty optional if this stream is empty.
   */
  @Test
  public void min() {
    OptionalInt min = Stream.of(1, -3, 5, 6, 10, -2).mapToInt(i -> i).min();
    assertFalse(min.isEmpty());
    assertEquals(min.getAsInt(), -3);
  }

  /*
   * Optional<T> min(Comparator<? super T> comparator)
   *
   * Returns the minimum element of this stream according to the provided Comparator.
   * This is a special case of a reduction.
   */
  @Test
  public void minV() {
    Optional<Integer> minOpt = Stream.of(-4, 2, 4, 9, 1, -9, 6).min(Integer::compareTo);
    assertFalse(minOpt.isEmpty());
    assertEquals(minOpt.get().intValue(), -9);
  }
}
