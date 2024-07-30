package com.malex.lecture_5_String.base.example_16_chars;

import com.malex.utils.AbstractUtils;
import java.util.stream.IntStream;
import org.junit.Test;

public class CharsExample extends AbstractUtils {

  @Test
  public void test() {
    String str = "It's a new string!";

    // #1 IntStream -> count()
    methodChars(str);
  }

  private void methodChars(String str) {
    IntStream chars = str.chars();
    long count = chars.count();
    print("Number of chars into the string: ", count);
  }
}
