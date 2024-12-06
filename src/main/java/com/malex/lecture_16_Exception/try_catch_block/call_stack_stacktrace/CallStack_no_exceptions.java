package com.malex.lecture_16_Exception.try_catch_block.call_stack_stacktrace;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Created by Alex on 4/18/2015. */
public class CallStack_no_exceptions extends AbstractUtils {

  @Test
  public void test() {
    method1();
    method2();
    method3();
  }

  private void method1() {
    // do something
    println("1");
  }

  private void method2() {
    // do something
    println("2");
  }

  private void method3() {
    // do something
    println("3");
  }
}
