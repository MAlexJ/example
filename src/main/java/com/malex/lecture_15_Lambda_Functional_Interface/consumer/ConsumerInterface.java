package com.malex.lecture_15_Lambda_Functional_Interface.consumer;

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
  public void runConsumerClass() {
    Consumer<String> consumer = new HashCodePrinter<>();
    consumer.accept("Hello!");
    consumer.accept("Java");
  }

  @Test
  public void methodReference() {
    Consumer<String> first = str -> println(str, "!");
    Consumer<String> second = this::println;

    first.accept("java");
    second.accept("java");
  }

  private static class HashCodePrinter<T> implements Consumer<T> {

    @Override
    public void accept(T t) {
      printlnString(String.valueOf(t.hashCode()));
    }
  }

  @Test
  public void runSampleAndThen() {
    Consumer<String> first = s1 -> println(s1 + 1);
    Consumer<String> second = first.andThen(s2 -> println(s2 + 2));
    Consumer<String> third = second.andThen(s2 -> println(s2 + 3));

    first.accept("hello");
    second.accept("world");
    third.accept("x");
  }

  @Test
  public void testSystemOut() throws IOException {
    var expectedResult = "xyy";
    var hello = "x";
    var world = "y";
    wrapperMethod(
        expectedResult,
        () -> {
          Consumer<String> first = this::print;
          Consumer<String> second = first.andThen(this::print);
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
