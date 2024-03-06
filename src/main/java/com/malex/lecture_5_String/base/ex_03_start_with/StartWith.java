package com.malex.lecture_5_String.base.ex_03_start_with;

import static junit.framework.TestCase.assertTrue;

import java.util.List;
import org.junit.Test;

/** if this string starts with the specified prefix */
public class StartWith {

  private final List<String> words = List.of("Java", "Python", "Hello word!");

  @Test
  public void startsWithSample() {
    var phrase = words.getFirst();
    boolean charResult = phrase.startsWith("J");
    assertTrue(charResult);

    boolean prefixResult = phrase.startsWith("Java");
    assertTrue(prefixResult);
  }

  @Test
  public void startsWithOffset() {
    var phrase = words.getLast();
    boolean startsWith = phrase.startsWith("ll", 2);
    assertTrue(startsWith);
  }
}
