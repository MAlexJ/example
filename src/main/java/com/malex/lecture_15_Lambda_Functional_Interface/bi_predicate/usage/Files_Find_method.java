package com.malex.lecture_15_Lambda_Functional_Interface.bi_predicate.usage;

import com.malex.utils.AbstractUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.Test;

public class Files_Find_method extends AbstractUtils {

  /*
  BiPredicate<T, U> = (path, _) -> String.valueOf(path).endsWith(".txt")
   */
  @Test
  public void test() throws IOException {
    // link: https://stackoverflow.com/questions/38609492/how-to-use-java-8-files-find-method
    Path pathToFolder = Paths.get("src");
    final int maxDepth = 10;
      try (Stream<Path> matches = Files.find(
              pathToFolder, maxDepth, (path, _) -> String.valueOf(path).endsWith(".txt"))) {
          matches.map(Path::getFileName).forEach(this::println);
      }
  }
}
