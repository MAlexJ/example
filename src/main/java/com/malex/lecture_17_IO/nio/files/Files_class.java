package com.malex.lecture_17_IO.nio.files;

import com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.flatmap.Flatmap_method;
import com.malex.utils.AbstractUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;
import org.junit.Test;

public class Files_class extends AbstractUtils {

  private static final String FILE_NAME;

  static {
    ClassLoader classLoader = Flatmap_method.class.getClassLoader();
    URL resource = classLoader.getResource("source/source.txt");
    FILE_NAME = resource.getFile();
  }

  @Test
  public void files() throws IOException {
    var path = new File(FILE_NAME).toPath();
    Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
    lines.forEach(this::println);
  }
}
