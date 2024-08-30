package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.flatmapTo.flatmapToInt;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

/*
 *
 * Returns an IntStream consisting of the results of replacing each element of this stream with
 * the contents of a mapped stream produced by applying the provided mapping function to each element
 *
 * This is an intermediate operation.
 */
public class FlatmapToInt_methods extends AbstractUtils {

  @Test
  public void flatmapToInt() {
    int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

    int[] resultArray = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
    print("array:", Arrays.toString(resultArray));
  }
}
