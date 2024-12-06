package com.malex.lecture_16_Exception.try_catch_block;

import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import org.junit.Test;

public class Block_try_catch_finally extends AbstractUtils {

  private static final boolean IS_ERROR = true;

  @Test
  public void test() {
    println("State:");

    try {
      println("0");

      if (IS_ERROR) {
        throw new SampleException("Throw Exception");
      }

      // The code block is not accessible.
      fail();
      println("1");
    } catch (Exception e) {
      println("2. exception:", e.toString());
    } finally {
      println("3");
    }

    println("4");
  }
}
