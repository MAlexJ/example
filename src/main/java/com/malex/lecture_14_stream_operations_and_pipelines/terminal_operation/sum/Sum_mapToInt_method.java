package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.sum;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.stream.Stream;
import org.junit.Test;

/*
* sum()
*
* This is a terminal operation.
*
* Returns the sum of elements in this stream.
* This is a special case of a reduction and is equivalent to:
   return reduce(0, Integer::sum);
*/
public class Sum_mapToInt_method extends AbstractUtils {

  @Test
  public void sum() {
    // given
    int sum =
        Stream.of(1, 2, 3) //
            .peek(this::println)
            .mapToInt(i -> i)
            .sum();

    // then
    print("sum:", sum);
    assertEquals(sum, 6);
  }

  @Test
  public void caseOfReduction() {
    // given
    int sum =
        Stream.of(1, 2, 3) //
            .peek(this::println)
            // .reduce(0, (first, second) -> first + second);
            .reduce(0, Integer::sum);

    // then
    print("sum:", sum);
    assertEquals(sum, 6);
  }
}
