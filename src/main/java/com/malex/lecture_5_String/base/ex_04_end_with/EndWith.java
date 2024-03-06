package com.malex.lecture_5_String.base.ex_04_end_with;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.List;
import org.junit.Test;

/** if this string ends with the specified suffix. */
public class EndWith {

  private final List<String> words = List.of("Java", "React", "Python");

  @Test
  public void endWith() {
    var first = words.getFirst();
    boolean endsWith = first.endsWith("va");
    assertTrue(endsWith);

    var last = words.getLast();
    assertFalse(last.endsWith("ct"));
  }
}
