package com.malex.lecture_5_String.formatter;

import java.util.Formatter;
import lombok.extern.java.Log;

@Log
public class SimpleFormatterApp {

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();
    try (Formatter fmt = new Formatter(sb)) {
      fmt.format("PI = %f%n", Math.PI);
    }

    log.info("Format: " + sb.toString());
    log.info("Original value: " + Math.PI);
  }
}
