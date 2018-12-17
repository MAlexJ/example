package com.malex.lecture_5_random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.log4j.Log4j;

@Log4j
public class LineGeneration {

  public static void main(String[] args) {

    log.debug(stringGeneration(10) + "\n");
    log.debug(stringGeneration(7) + "\n");
    log.debug(stringGeneration(2) + "\n");

    try {
      log.debug(stringGeneration(ThreadLocalRandom.current().nextInt(-10, 0)) + "\n");
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }
  }

  private static String stringGeneration(int numberOfCharacters) {

    if (numberOfCharacters <= 0) {
      throw new ArithmeticException("Incorrect numberOfCharacters: " + numberOfCharacters);
    }

    StringBuilder sb = new StringBuilder();
    char[] chars = {
      'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
      'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S',
      'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '_', '0', '1', '2', '3',
      '4', '5', '6', '7', '8', '9'
    };

    int limit = chars.length - 1;
    for (int i = 0; i < numberOfCharacters; i++) {
      sb.append(chars[new Random().nextInt(limit)]);
    }

    return sb.toString();
  }
}
