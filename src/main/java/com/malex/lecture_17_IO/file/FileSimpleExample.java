package com.malex.lecture_17_IO.file;

import com.malex.utils.AbstractUtils;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import org.junit.Test;

public class FileSimpleExample extends AbstractUtils {

  private static final String ERROR_MESSAGE = "File not found: %s";

  private static final String PATH_TO_FILE = "source/file.txt";

  @Test
  public void test() throws URISyntaxException {
    URL resource = FileSimpleExample.class.getClassLoader().getResource(PATH_TO_FILE);
    if (Objects.isNull(resource)) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE, PATH_TO_FILE));
    }

    URI uri = resource.toURI();
    File file = new File(uri);
    print("It is the directory: " + file.isDirectory());
    print("File name: " + file.getName());
    print("The file is exist: " + file.exists());
    // file.delete();
  }
}
