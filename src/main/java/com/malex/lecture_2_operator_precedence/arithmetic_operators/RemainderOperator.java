package com.malex.lecture_2_operator_precedence.arithmetic_operators;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.stream.Stream;
import org.junit.Test;

public class RemainderOperator extends AbstractUtils {

  /**
   * Remainder operator java when dividing 1 by x -
   * https://stackoverflow.com/questions/29225141/remainder-operator-java-when-dividing-1-by-x
   */
  @Test
  public void test() {
    /*
    For x % y, where x is smaller than y, what is left over is the value of x.
    So for 1 % 3, left over is 1. For 2 % 11, left over is 2
     */
    assertEquals(0, remainder(0, 3));
    assertEquals(1, remainder(1, 3));
    assertEquals(2, remainder(2, 3));
    assertEquals(0, remainder(3, 3));
    assertEquals(1, remainder(4, 3));
    assertEquals(2, remainder(5, 3));
    assertEquals(0, remainder(6, 3));
  }

  private int remainder(int first, int second) {
    int result = first % second;
    println(first, "%", second, "=", result);
    return result;
  }

  /*
   * Even numbers
   */
  @Test
  public void evenNumbers() {
    Stream.iterate(0, i -> i + 1) //
        .filter(i -> i % 2 == 0)
        .limit(10)
        .forEach(this::println);
  }
}
