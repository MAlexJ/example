package com.malex.lecture_5_String.example_16_chars;

import java.util.stream.IntStream;
import lombok.extern.java.Log;

@Log
public class CharsExample {

  public static void main(String[] args) {
    String str = "It's a new string!";

    // #1 IntStream -> count()
    methodChars(str);
  }

  private static void methodChars(String str) {
    IntStream chars = str.chars();
    long count = chars.count();

    log.info("Number of chars into the string: " + count + "\n");
  }
}
