package com.malex.lecture_2_operator_precedence.bitwise_and_bit_shift_operators;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class UnsignedRightShift extends AbstractUtils {

  @Test
  public void unsignedRightShiftTest() {
    // For positive number, >> and >>> works same
    println(20 >> 2);
    println(20 >>> 2);

    // For negative number, >>> changes parity bit (MSB) to 0
    println(-20 >> 2);
    println(-20 >>> 2);
  }

  /** For positive number, >> and >>> works same */
  @Test
  public void forPositiveNumber() {
    assertEquals(20 >> 2, 20 >>> 2);
    assertEquals(20 >> 1, 20 >>> 1);
    assertEquals(7 >> 3, 7 >>> 3);
  }

  /** For negative number, >>> changes parity bit (MSB) to 0 */
  @Test
  public void forNegativeNumber() {
    assertEquals(Integer.MAX_VALUE, -1 >>> 1);
    println(Integer.MAX_VALUE);
    println(-1 >>> 1);
    println(-2 >>> 1);
    println(-3 >>> 1);
    println(-4 >>> 1);
    println(-5 >>> 1);
    println(-6 >>> 1);
    println(-7 >>> 1);
    println(-8 >>> 1);
    println(-9 >>> 1);
    println(-10 >>> 1);
  }

  @Test
  public void forNegativeNumber2() {
    assertEquals(Integer.MAX_VALUE / 2, -1 >>> 2);
    println(-1 >>> 2);
    println(-2 >>> 2);
    println(-3 >>> 2);
    println(-4 >>> 2);
    println(-5 >>> 2);
    println(-6 >>> 2);
    println(-7 >>> 2);
    println(-8 >>> 2);
    println(-9 >>> 2);
    println(-10 >>> 2);

    assertEquals(Integer.MAX_VALUE / 4, -1 >>> 3);
  }
}
