package com.malex.lecture_4_algorithms.strings.remove_digits_from_string;

public class StringReplaceAll extends TestApp {

  private static final String DIGIT_REGEX = "\\d";
  private static final String STRING_REPLACEMENT = "";

  public StringReplaceAll() {
    super("Using String‘s replaceAll()");
  }

  @Override
  public String removeDigits(String str) {
    return str.replaceAll(DIGIT_REGEX, STRING_REPLACEMENT);
  }
}
