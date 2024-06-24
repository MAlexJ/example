package com.malex.lecture_4_algorithms.strings.remove_digits_from_string;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

abstract class TestApp extends AbstractUtils {

  private String testClassName;

  TestApp(String testClassName) {
    this.testClassName = testClassName;
  }

  abstract String removeDigits(String str);

  @Test
  public void test() {
    println("Starting test:", testClassName);
    assertEquals("qwerty", removeDigits("q1w2e34r5ty0"));
    assertEquals("", removeDigits("123465463"));
    assertEquals(" ", removeDigits(" "));
    assertEquals(" ", removeDigits(" 1"));
    println("End test:", testClassName);
  }
}
