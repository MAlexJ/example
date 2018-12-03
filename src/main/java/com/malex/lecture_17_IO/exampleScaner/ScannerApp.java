package com.malex.lecture_17_IO.exampleScaner;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class ScannerApp {

  private static final Logger LOG = Logger.getLogger(ScannerApp.class);

  /** encoding type for scanner */
  private static final String ENCODING_TYPE = StandardCharsets.UTF_8.name();

  public static void main(String[] args) {

    LOG.debug("Enter an integer: ");
    Scanner scanner = new Scanner(System.in, ENCODING_TYPE);
    int i;

    // returns true if an integer can be read from the input stream
    if (scanner.hasNextInt()) {
      // reads an integer from the input stream and stores it in a variable
      i = scanner.nextInt();
      LOG.debug(i * 2);
    } else {
      LOG.debug("You did not enter an integer!");
    }
  }
}
