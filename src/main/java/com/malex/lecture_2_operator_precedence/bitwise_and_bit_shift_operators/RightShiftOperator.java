package com.malex.lecture_2_operator_precedence.bitwise_and_bit_shift_operators;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Java Right Shift Operator
 *
 * <p>The Java right shift operator >> is used to move the value of the left operand to right by the
 * number of bits specified by the right operand.
 */
public class RightShiftOperator extends AbstractUtils {

  @Test
  public void test() {
    // 10 / 2 ^ 2 = 10 / 4 = 2
    println(10 >> 2);
    // 20 / 2 ^ 2 = 20 / 4 = 5
    println(20 >> 2);
    // 20 / 2 ^ 3 = 20 / 8 = 2
    println(20 >> 3);

    // 10 / 2 ^ 1 = 10 / 2 = 2
    assertEquals((10 >> 1), 5);

    // 5 / 2 ^ 1 = 5 / 2 = 2
    assertEquals((5 >> 1), 2);

    // 10 / 2 ^ 3 = 10 / 8 = 1
    assertEquals((10 >> 3), 1);
  }
}
