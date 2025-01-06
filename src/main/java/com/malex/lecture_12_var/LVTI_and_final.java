package com.malex.lecture_12_var;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

/*
 * Q3. Is a var variable final?
 *
 * link: https://openjdk.org/projects/amber/guides/lvti-faq
 *
 * No. Local variables declared with var are non-final by default.
 * However, the final modifier can be added to var declarations:
 *
 * final var person = new Person();
 *
 * There is no shorthand for final var in Java.
 */
public class LVTI_and_final {

  // not compile:   final var x = new String("Alex");

  @Test
  public void test() {
    // only local variable can final
    final var name = new String("Alex");

    assertEquals(name, "Alex");
  }
}
