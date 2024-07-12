package com.malex.lecture_2_operator_precedence.bitwise_and_bit_shift_operators;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Java Left Shift Operator
 *
 * <p>The Java left shift operator << is used to shift all of the bits in a value to the left side
 * of a specified number of times.
 */
public class LeftShiftOperator extends AbstractUtils {

  @Test
  public void test() {
    // 10 * 2 ^ 2  = 10 * 4
    assertEquals((10 << 2), 40);
    println("(10 << 2) = 10 * 2 ^ 2  = 10 * 4 = ", (10 << 2));

    // 10 * 2 ^ 3 = 10 * 8 =80
    assertEquals((10 << 3), 80);

    // 15 * 2 ^ 4 = 15 * 16 = 240
    assertEquals((15 << 4), 210);
  }

  /**
   * Java Left Shift Operator is equals 2 ^ n
   *
   * <pre>
   * 2^1=2
   * 2^2=4
   * 2^3=8
   * 2^4=16
   * 2^5=32
   * 2^6=64
   * 2^7=128
   * 2^8=256
   * 2^9=512
   * 2^10=1024
   * </pre>
   */
  @Test
  public void cube() {
    println(1 << 1);
    println(1 << 2);
    println(1 << 3);
    println(1 << 4);
  }
}
