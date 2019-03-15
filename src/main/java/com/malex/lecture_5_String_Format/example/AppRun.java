package com.malex.lecture_5_String_Format.example;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Formatter;
import java.util.Optional;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class AppRun {

  private static final Logger LOG = Logger.getLogger(AppRun.class);

  private static final String SOURCE_FILE;
  private static final String PATH_SOURCE = "format.txt";

  private static final String ERROR_MESSAGE = "File not found: %s";

  static {
    ClassLoader context = Thread.currentThread().getContextClassLoader();
    URL sourceRes =
        Optional.ofNullable(context.getResource(PATH_SOURCE))
            .orElseThrow(
                () -> {
                  String errorMessage = String.format(ERROR_MESSAGE, PATH_SOURCE);
                  LOG.error(errorMessage);
                  return new IllegalArgumentException(errorMessage);
                });
    SOURCE_FILE = sourceRes.getFile();
  }

  /** //%s - String //%d - integer type number //%f - double type number // /n - new line */
  public static void main(String[] args) {

    try (Formatter formatter = new Formatter(SOURCE_FILE);
        Scanner scanner = new Scanner(System.in)) {

      LOG.debug("Write to file -> ");

      String line = scanner.nextLine();
      formatter.format(line, "Alex");

      LOG.debug(">>> exit ");
    } catch (FileNotFoundException ex) {
      LOG.error(ex.getMessage());
    }
  }
}
