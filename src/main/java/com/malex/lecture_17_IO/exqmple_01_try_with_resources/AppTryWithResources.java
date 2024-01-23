package com.malex.lecture_17_IO.exqmple_01_try_with_resources;

import com.malex.lecture_17_IO.AbstractReadFile;
import java.io.*;
import org.junit.Test;

public class AppTryWithResources extends AbstractReadFile {

  @Test
  public void testTryWithResourcesJava7() throws IOException {
    try (InputStream in = new FileInputStream(PATH_TO_SOURCE_FILE)) {
      int s;
      while ((s = in.read()) != -1) {
        print((char) s);
      }
    }
  }

  @Test
  public void testTryWithResourcesJava21() throws IOException {
    final InputStream in = new FileInputStream(PATH_TO_SOURCE_FILE);
    try (in) {
      int s;
      while ((s = in.read()) != -1) {
        print((char) s);
      }
    }
  }
}
