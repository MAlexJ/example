package com.malex.lecture_4_algorithms.strings.remove_digits_from_string;

public class StringBuilderAndLoop extends TestApp {
  public StringBuilderAndLoop() {
    super("Using Loop and StringBuilder");
  }

  @Override
  public String removeDigits(String str) {
    StringBuilder sb = new StringBuilder();
    for (char ch : str.toCharArray()) {
      if (!Character.isDigit(ch)) {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
