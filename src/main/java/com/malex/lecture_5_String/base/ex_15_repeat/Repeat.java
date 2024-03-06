package com.malex.lecture_5_String.base.ex_15_repeat;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Returns a string whose value is the concatenation of this string repeated count times. */
public class Repeat extends AbstractUtils {

  private final String phrase = "Hello! ";

  @Test
  public void repeat() {
    var repeat = phrase.repeat(3);
    println(repeat);
  }

  @Test
  public void repeat2() {
    var repeat = phrase.repeat(1);
    println(repeat);
  }
}
