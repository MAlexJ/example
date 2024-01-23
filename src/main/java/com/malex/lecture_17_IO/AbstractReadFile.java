package com.malex.lecture_17_IO;

import com.malex.utils.AbstractUtils;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

public abstract class AbstractReadFile extends AbstractUtils {

  /** folder file location */
  private static final String SOURCE_FILE_LOCATION = "source/source.txt";

  private static final String DESTINATION_FILE_LOCATION = "destination/destination.txt";

  /** Path to files: */
  protected static final String PATH_TO_SOURCE_FILE;

  protected static final String PATH_TO_DESTINATION_FILE;

  /** URI to files: */
  protected static final URI PATH_TO_SOURCE_URL;

  protected static final URI URL_PATH_TO_DESTINATION;

  static {
    ClassLoader context = Thread.currentThread().getContextClassLoader();
    URL sourceUrl = context.getResource(SOURCE_FILE_LOCATION);
    URL destinationUrl = context.getResource(DESTINATION_FILE_LOCATION);
    if (Objects.isNull(sourceUrl) || Objects.isNull(destinationUrl)) {
      String message =
          String.format(
              "File not found: %s",
              Objects.isNull(sourceUrl) ? SOURCE_FILE_LOCATION : DESTINATION_FILE_LOCATION);
      throw new IllegalArgumentException(message);
    }

    PATH_TO_SOURCE_FILE = sourceUrl.getFile();
    PATH_TO_DESTINATION_FILE = destinationUrl.getFile();

    PATH_TO_SOURCE_URL = URI.create(sourceUrl.toString());
    URL_PATH_TO_DESTINATION = URI.create(PATH_TO_DESTINATION_FILE);
  }
}
