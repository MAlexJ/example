package com.malex.lecture_4_algorithms.strings.reduce_string;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

abstract class TestApp extends AbstractUtils {

  private String testClassName;

  public TestApp(String testClassName) {
    this.testClassName = testClassName;
  }

  /**
   * Reduce the string based on the criteria
   *
   * @param input - string
   * @param length - string length limit.
   */
  abstract String reduceString(String input, int length);

  @Test
  public void test() {
    println("Test:", testClassName);
    assertEquals("", reduceString("", 1));
    assertEquals("qwerty", reduceString("qwerty qwerty", 1));
    assertEquals("qwerty qwerty", reduceString("qwerty qwerty qwerty", 15));
  }
}
