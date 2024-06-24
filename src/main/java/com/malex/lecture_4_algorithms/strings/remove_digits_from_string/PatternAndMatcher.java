package com.malex.lecture_4_algorithms.strings.remove_digits_from_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher extends TestApp {

  private static final String DIGIT_REGEX = "\\d";
  private static final String STRING_REPLACEMENT = "";

  public PatternAndMatcher() {
    super("Using Pattern and Matcher");
  }

  @Override
  String removeDigits(String str) {
    Pattern pattern = Pattern.compile(DIGIT_REGEX);
    Matcher matcher = pattern.matcher(str);
    return matcher.replaceAll(STRING_REPLACEMENT);
  }
}
