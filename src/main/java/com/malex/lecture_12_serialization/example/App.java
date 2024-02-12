package com.malex.lecture_12_serialization.example;

import static com.malex.lecture_12_serialization.example.util.SerializationUtils.deserialization;
import static com.malex.lecture_12_serialization.example.util.SerializationUtils.serialization;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import lombok.extern.java.Log;

@Log
public class App {

  private static final String FILE_NAME = "source.txt";
  private static final String PATH_SOURCE = "serialization/%s";
  private static final String ERROR_MESSAGE = "File '%s' not found!";
  private static final File SOURCE_FILE;

  static {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL resource = classLoader.getResource(String.format(PATH_SOURCE, FILE_NAME));
    //  Gets the file name of this URL
    String path =
        Optional.ofNullable(resource)
            .orElseThrow(() -> new RuntimeException(String.format(ERROR_MESSAGE, FILE_NAME)))
            .getFile();
    SOURCE_FILE = new File(path);
  }

  public static void main(String[] args) {
    String str = "Hello!";

    // #1 serialization
    log.info("Before: " + str);
    serialization(SOURCE_FILE, str);

    // #2 deserialization
    String newStr = deserialization(SOURCE_FILE, String.class);
    log.info("After: " + newStr);
  }
}
