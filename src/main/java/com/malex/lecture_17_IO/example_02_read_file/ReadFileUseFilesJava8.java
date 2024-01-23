package com.malex.lecture_17_IO.example_02_read_file;

import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_17_IO.AbstractReadFile;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.Test;

public class ReadFileUseFilesJava8 extends AbstractReadFile {

  private static final String DELIMITER = "\n";

  /** Source file in resources: "source/source.txt" */
  @Test
  public void testReadSourceFileByLine() {
    // given
    String text = readLineByLine();
    println(text);

    // then
    assertTrue(text.contains("Source file"));
  }

  /**
   * Read file content into string with - Files.lines(Path ..., Charset ...)
   *
   * @return string with context from a file
   */
  private String readLineByLine() {
    StringBuilder builder = new StringBuilder();
    Path path = new File(PATH_TO_SOURCE_URL).toPath();

    // Read all lines from a file as a {@code Stream}.
    try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
      lines.forEach(line -> builder.append(line).append(DELIMITER));
    } catch (IOException ex) {
      ex.fillInStackTrace();
    }

    return builder.toString();
  }
}
