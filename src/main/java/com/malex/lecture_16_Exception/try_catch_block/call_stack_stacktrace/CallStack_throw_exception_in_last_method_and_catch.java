package com.malex.lecture_16_Exception.try_catch_block.call_stack_stacktrace;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class CallStack_throw_exception_in_last_method_and_catch extends AbstractUtils {

  private boolean isActive = false;
  private boolean isError = false;

  @Test
  public void test() {
    println("#1.in");
    try {
      f();
    } catch (Error e) {
      isError = true;
      println("#1.CATCH");
    }
    println("#1.out");

    // pass
    assertTrue(isError);

    /*
     * out of bounds code in h methods
     */
    assertFalse(isActive);
  }

  public void f() {
    println(".   #2.in");
    g();
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

    /*
     * out of bounds code
     */
    isActive = true;
    println(".   .   .   #4.out");
  }
}
