package com.malex.lecture_4_algorithms.strings.reduce_string;

import java.util.Objects;

public class ReduceStringToLastSpace extends TestApp {

  public ReduceStringToLastSpace() {
    super("Reduce the string to last space");
  }

  @Override
  String reduceString(String input, int length) { // todo implement : length params
    if (Objects.isNull(input) || input.isBlank()) {
      return input;
    }
    int lastIndexOf = input.lastIndexOf(" ");
    /*
       Range [0, -1) out of bounds for length 0
    */
    if (lastIndexOf == -1) {
      return input;
    }
    /*
    - beginIndex – the beginning index, inclusive.
    - endIndex – the ending index, exclusive.
     */
    return input.substring(0, lastIndexOf);
  }
}
