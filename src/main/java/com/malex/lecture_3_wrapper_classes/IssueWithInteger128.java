package com.malex.lecture_3_wrapper_classes;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Conclusion: you can not compare reference variables ==, only equals() */
public class IssueWithInteger128 extends AbstractUtils {

  @Test
  public void runApp() {
    Integer i1 = 128;
    Integer i2 = 128;
    println("i1 =", i1, ",i2 =", i2, "\n");

    println("Equals:", i1.equals(i2));
    assertEquals(i1, i2);

    println("Compare link:", i1 == i2);
    assertNotSame(i1, i2);
  }

  @Test
  public void runApp127() {
    Integer i1 = 127;
    Integer i2 = 127;
    fullyIdentical(i1, i2);
  }

  @Test
  public void runAppMinus128() {
    Integer i1 = -128;
    Integer i2 = -128;
    fullyIdentical(i1, i2);
  }

  /** fully identical objects */
  private void fullyIdentical(Integer i1, Integer i2) {
    println("i1 =", i1, ",i2 =", i2, "\n");

    println("Equals:", i1.equals(i2));
    assertEquals(i1, i2);

    println("Compare link:", i1 == i2);
    assertSame(i1, i2);
  }
}
