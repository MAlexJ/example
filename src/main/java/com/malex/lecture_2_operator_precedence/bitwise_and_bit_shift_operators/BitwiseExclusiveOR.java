package com.malex.lecture_2_operator_precedence.bitwise_and_bit_shift_operators;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * bitwise inclusive OR - |
 *
 * <p>The bitwise operator always checks both conditions whether first condition is true or false.
 */
public class BitwiseExclusiveOR extends AbstractUtils {

  @Test
  public void test() {
    println(
        "The bitwise operator always checks both conditions whether first condition is true or false.");
    assertEquals(true, true | true);
    assertEquals(true, true | false);
    assertEquals(true, false | true);
    assertEquals(false, false | false);
  }
}
