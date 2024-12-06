package com.malex.lecture_16_Exception.try_catch_block;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import org.junit.Test;

public class Block_try_finally extends AbstractUtils {

  private static final boolean IS_ERROR = true;

  @Test(expected = SampleException.class)
  public void test() {
    println("State:");

    try {
      println("0");

      if (IS_ERROR) {
        throw new SampleException("Throw Exception");
      }

      println("1");
    } finally {
      println("2");
    }

    println("3");
  }
}
