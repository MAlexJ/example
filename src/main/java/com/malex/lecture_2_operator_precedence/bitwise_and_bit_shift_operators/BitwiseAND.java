package com.malex.lecture_2_operator_precedence.bitwise_and_bit_shift_operators;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * The bitwise & operator always checks both conditions whether first condition is true or false
 */
public class BitwiseAND extends AbstractUtils {

  @Test
  public void logicalBitwise() {
    println("true & true = true");
    boolean condition = condition(true, "first") & condition(true, "second");
    assertTrue(condition);

    println("\nfalse & true = false");
    condition = condition(false, "first") & condition(true, "second");
    assertFalse(condition);

    println("\ntrue & false = false");
    condition = condition(true, "first") & condition(false, "second");
    assertFalse(condition);

    println("\nfalse & false = false");
    condition = condition(false, "first") & condition(false, "second");
    assertFalse(condition);
  }

  private boolean condition(boolean condition, String message) {
    println("  ", message, "is " + condition);
    return condition;
  }

  @Test
  public void test() {
    println(4 & 4);
    println(4 & 3);
    println(3 & 4);
    println(3 & 2);
    println(2 & 2);
    println(1 & 2);
    println(1 & 1);
    println(0 & 1);
    println(0 & 0);
    println(1 & 0);
  }
}
