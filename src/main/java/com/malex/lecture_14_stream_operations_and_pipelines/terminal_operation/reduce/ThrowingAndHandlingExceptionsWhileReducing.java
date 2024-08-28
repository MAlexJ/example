package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.reduce;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

public class ThrowingAndHandlingExceptionsWhileReducing extends AbstractUtils {

  /*
  For instance, say that we need to divide all the elements of a stream by a supplied factor
  and then sum them:

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int divider = 2;
    int result = numbers.stream().reduce(0, a / divider + b / divider);
   */
  @Test
  public void test() {
    var factor = 0;
    var list = List.of(1, 2, 3, 4);
    var result = divideListElements(list, factor);

    result = divideListElements(list, 1);
    assertEquals(result.intValue(), 10);

    println("result:", result);
  }

  private Integer divideListElements(List<Integer> list, int factor) {
    return list.stream()
        .reduce(
            0,
            (a, b) -> {
              return divide(a, factor) + divide(b, factor);
            });
  }

  private Integer divide(int value, int factor) {
    try {
      return value / factor;
    } catch (ArithmeticException e) {
      return 0;
    }
  }
}
