package com.malex.lecture_1_primitive;

import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Created by MAlex on 1/30/2015. */
public class DivisionByZeroSample extends AbstractUtils {

  @Test
  public void runSAmple() {

    println("int a=0 / int b=2: ", 0 / 2);

    /*
    Exception java.lang.ArithmeticException: / by zero
    println("int a=2 / int b=0: "+ 2/0);
    This result -> Infinity
    */
    try {
      println("int a=2 / int b=0: ", 2 / 0);
      fail();
    } catch (ArithmeticException ex) {
      // none
    }

    println("float a=2f / int b=0: ", 2f / 0);

    /* This result -> Infinity */
    println("double t a=2d / int b=0: ", 2d / 0);

    /* This result -> 0.0 */
    println("int b=0 /double t a=2d ", 0 / 2d);

    /* This result -> NaN */
    println("double t a=0d / int b=0: ", 0d / 0);
  }
}
