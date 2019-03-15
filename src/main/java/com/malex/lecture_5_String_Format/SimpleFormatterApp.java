package com.malex.lecture_5_String_Format;

import java.util.Formatter;
import lombok.extern.log4j.Log4j;

@Log4j
public class SimpleFormatterApp {

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();
    try (Formatter fmt = new Formatter(sb)) {
      fmt.format("PI = %f%n", Math.PI);
    }

    log.debug("Format: " + sb.toString());
    log.debug("Original value: " + Math.PI);
  }
}
