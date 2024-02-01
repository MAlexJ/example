package com.malex.lecture_1_primitive;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * In case of abbreviated operations in java, type casting is performed. That is, v1 + = v2 is
 * analogous to v1 = (int) (v1 + v2) Accordingly, the first line will have a compilation error since
 * long is wider than int, and the second line will be successfully executed.
 */
public class OperationsTypeCasting extends AbstractUtils {

  @Test
  public void runSample() {
    println("8 / 2 =", 8 / 2);
    println("9 / 2 =", 9 / 2);
    println("9 % 2 =", 9 % 2);
  }
}
