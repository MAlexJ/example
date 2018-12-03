package com.malex.lecture_17_IO.exampleReadFile;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.apache.log4j.Logger;

public class ReadFileBytesToString {

  private static final Logger LOG = Logger.getLogger(ReadFileBytesToString.class);

  private static final String SOURCE_FILE;
  private static final String PATH_SOURCE = "source/source.txt";

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

  public static void main(String[] args) {
    String text = readAllBytesFromFile();
    LOG.debug(text);
  }

  /** Read file content into string with - Files.readAllBytes(Path path) */
  private static String readAllBytesFromFile() {
    try {
      Path path = Paths.get(SOURCE_FILE);
      byte[] bytes = Files.readAllBytes(path);
      return new String(bytes, StandardCharsets.UTF_8);
    } catch (IOException e) {
      LOG.error(e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }
}
