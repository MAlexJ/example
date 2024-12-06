package com.malex.lecture_16_Exception.try_catch_block.call_stack_stacktrace;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class CallStack_suppress_exception extends AbstractUtils {

  private boolean isActive = false;
  private boolean errorWasCaught = false;

  @Test
  public void test() {
    println("#1.in");
    f();
    println("#1.out");

    // pass
    assertTrue(errorWasCaught);

    /*
     * out of bounds code in h methods
     */
    assertFalse(isActive);
  }

  public void f() {
    println(".   #2.in");
    try {
      g();
    } catch (Error e) {
      errorWasCaught = true;
      println(".   #2.CATCH");
    }
    println(".   #2.out");
  }

  public void g() {
    println(".   .   #3.in");
    h();
    println(".   .   #3.out");
  }

  public void h() {
    println(".   .   .   #4.in");
    if (true) {
      println(".   .   .   #4.THROW");
      throw new Error();
    }

    println(".   .   .   #4.out");
  }
}
