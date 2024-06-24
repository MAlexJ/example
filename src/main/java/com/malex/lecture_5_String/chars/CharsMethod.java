package com.malex.lecture_5_String.chars;

import com.malex.utils.AbstractUtils;
import java.util.stream.IntStream;
import org.junit.Test;

public class CharsMethod extends AbstractUtils {

  /**
   * Returns a stream of int zero-extending the char values from this sequence. Any char which maps
   * to a surrogate code point is passed through uninterpreted.
   */
  @Test
  public void test() {
    String hello = "Hello";
    IntStream chars = hello.chars();
    chars.forEach(c -> print("int: ", c, ", char:", (char) c, "\n"));
  }
}
