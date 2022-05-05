package com.malex.lecture_17_IO.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import lombok.extern.java.Log;

@Log
public class FileSimpleExample {

  private static final String ERROR_MESSAGE = "File not found: %s";

  private static final String PATH_TO_FILE = "source/file.txt";

  public static void main(String[] args) throws URISyntaxException {
    URL resource = FileSimpleExample.class.getClassLoader().getResource(PATH_TO_FILE);
    if (Objects.isNull(resource)) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE, PATH_TO_FILE));
    }

    URI uri = resource.toURI();
    File file = new File(uri);
    log.info("It is the directory: " + file.isDirectory());
    log.info("File name: " + file.getName());
    log.info("The file is exist: " + file.exists());
    // file.delete();
  }
}
