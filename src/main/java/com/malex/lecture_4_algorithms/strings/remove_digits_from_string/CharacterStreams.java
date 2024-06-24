package com.malex.lecture_4_algorithms.strings.remove_digits_from_string;

import java.util.stream.Collectors;

public class CharacterStreams extends TestApp {

  public CharacterStreams() {
    super("Using Character Streams");
  }

  @Override
  public String removeDigits(String str) {
    return str.chars()
        .filter(ch -> !Character.isDigit(ch))
        .mapToObj(Character::toString)
        .collect(Collectors.joining());
  }
}
