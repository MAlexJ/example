package com.malex.lecture_5_math;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class Abs extends AbstractUtils {

  @Test
  public void abs() {
    int abs = -3;
    println("abs:", abs, "=", Math.abs(abs));

    abs = 3;
    println("abs:", abs, "=", Math.abs(abs));

    abs = 0;
    println("abs:", abs, "=", Math.abs(abs));
  }
}
