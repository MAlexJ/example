package com.malex.lecture_17_IO.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import lombok.extern.log4j.Log4j;

@Log4j
public class CopyFileIO {

  private static final String PATH_TO_SRS = "source/file.txt";
  private static final String PATH_TO_DESTINATION = "destination/file.txt";

  private static final String ERROR_COPY_FILE = "An error occurred while copy the file '%s'";
  private static final String ERROR_MESSAGE = "File not found: %s";

  public static void main(String[] args) throws URISyntaxException {

    URI fileUri = getUrl().toURI();
    File source = new File(fileUri);

    String destPath = source.getAbsolutePath().replace(PATH_TO_SRS, PATH_TO_DESTINATION);
    File destination = new File(destPath);

    try (FileInputStream fileInputStream = new FileInputStream(source);
        FileOutputStream fileOutputStream = new FileOutputStream(destination)) {

      int temp;
      while (true) {
        temp = fileInputStream.read();
        if (temp != -1) {
          fileOutputStream.write(temp);
        } else {
          log.debug("File '" + source.getName() + "' copied successfully!");
          break;
        }
      }
    } catch (IOException e) {
      String errorMessage = String.format(ERROR_COPY_FILE, source.getName());
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private static URL getUrl() {
    URL resourceSrs = CopyFileIO.class.getClassLoader().getResource(PATH_TO_SRS);

    if (Objects.isNull(resourceSrs)) {
      String errorMessage = String.format(ERROR_MESSAGE, PATH_TO_SRS);
      log.error(errorMessage);
      throw new IllegalArgumentException(errorMessage);
    }

    return resourceSrs;
  }
}
