package com.malex.lecture_2_operator_precedence.bitwise_and_bit_shift_operators.algoritms;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class BitwiseOperatorTrick extends AbstractUtils {

  /** bitwise operator trick: size >> 1 means that, size is divided by 2. */
  @Test
  public void trick() {
    int size = 7;
    println("size >> 1 = ", size >> 1);
    println("size / 2 = ", size / 2);

    for (int i = 0; i < 100; i++) {
      int first = i >> 1;
      int second = i / 2;
      assertEquals(first, second);
    }
  }
}
