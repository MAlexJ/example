package com.malex.lecture_17_IO.exampleReadFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;
import org.apache.log4j.Logger;

/** JAVA 7 closing resources automatically */
public class ReadFileToConsoleUseJava7 {
  private static final Logger LOG = Logger.getLogger(ReadFileToConsoleUseJava7.class);

  private static final String PATH_SOURCE = "source/source.txt";
  private static final String PATH_DESTINATION = "destination/destination.txt";

  private static final String ERROR_MESSAGE = "File not found: %s";

  private static final String SOURCE_FILE;
  private static final String DESTINATION_FILE;

  static {
    ClassLoader context = Thread.currentThread().getContextClassLoader();

    URL sourceRes = context.getResource(PATH_SOURCE);
    URL destinationRes = context.getResource(PATH_DESTINATION);

    if (Objects.isNull(sourceRes) || Objects.isNull(destinationRes)) {
      String message =
          String.format(ERROR_MESSAGE, Objects.isNull(sourceRes) ? PATH_SOURCE : PATH_DESTINATION);
      throw new IllegalArgumentException(message);
    }

    SOURCE_FILE = sourceRes.getFile();
    DESTINATION_FILE = destinationRes.getFile();
  }

  public static void main(String[] args) {
    try (InputStream in = new FileInputStream(SOURCE_FILE);
        OutputStream out = new FileOutputStream(DESTINATION_FILE)) {
      int s;
      while ((s = in.read()) != -1) {
        LOG.debug((char) s);
        out.write(s);
      }
    } catch (IOException ex) {
      LOG.error(ex.getMessage());
    }
  }
}
