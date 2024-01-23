package com.malex.lecture_17_IO.example_02_read_file;

import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_17_IO.AbstractReadFile;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;

public class ReadFileBytesToString extends AbstractReadFile {

  @Test
  public void runReadFileBytes() throws IOException {
    // given
    String text = readAllBytesFromFile();
    println(text);

    // then
    assertTrue(text.contains("Source file"));
  }

  /** Read file content into string with - Files.readAllBytes(Path ...) */
  private String readAllBytesFromFile() throws IOException {
    Path path = new File(PATH_TO_SOURCE_URL).toPath();
    byte[] bytes = Files.readAllBytes(path);
    return new String(bytes, StandardCharsets.UTF_8);
  }
}
