package com.malex.lecture_17_IO.example_03_scaner;

import com.malex.utils.AbstractUtils;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ScannerApp extends AbstractUtils {

  /** scanner encoding type */
  private static final String ENCODING_TYPE = StandardCharsets.UTF_8.name();

  public static void main(String[] args) {
    printlnString("Enter integer number: ");
    Scanner scanner = new Scanner(System.in, ENCODING_TYPE);
    // returns true if an integer can be read from the input stream
    if (scanner.hasNextInt()) {
      // reads an integer from the input stream and stores it in a variable
      int i = scanner.nextInt();
      printlnString("> " + i * 2);
    } else {
      printlnString("You did not enter an integer!");
    }
  }
}
