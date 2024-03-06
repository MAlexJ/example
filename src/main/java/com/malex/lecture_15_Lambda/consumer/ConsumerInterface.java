package com.malex.lecture_15_Lambda.consumer;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Consumer;
import lombok.extern.java.Log;
import org.junit.Test;

/**
 * FunctionalInterface Consumer
 *
 * <p>Represents an operation that accepts a single input argument and returns no result. Unlike
 * most other functional interfaces, Consumer is expected to operate via side-effects.
 */
@Log
public class ConsumerInterface extends AbstractUtils {

  @Test
  public void runSample() {
    Consumer<String> first = s1 -> println(s1 + 1);
    Consumer<String> second = first.andThen(s2 -> println(s2 + 2));
    Consumer<String> third = second.andThen(s2 -> println(s2 + 3));

    first.accept("hello");
    second.accept("world");
    third.accept("x");
  }

  @Test
  public void test() throws IOException {
    var expectedResult = "xyy";
    var hello = "x";
    var world = "y";
    wrapperMethod(
        expectedResult,
        () -> {
          Consumer<String> first = s1 -> print(s1);
          Consumer<String> second = first.andThen(s2 -> print(s2));
          first.accept(hello);
          second.accept(world);
        });
  }

  public void wrapperMethod(String expected, Runnable r) throws IOException {
    try (var out = new ByteArrayOutputStream();
        var printStream = new PrintStream(out)) {
      System.setOut(printStream);
      r.run();
      assertEquals(expected, out.toString());
    } catch (IOException ex) {
      printError(ex.getMessage());
      throw ex;
    }
  }
}
