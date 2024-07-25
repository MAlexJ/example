package com.malex.lecture_15_Lambda_Functional_Interface.function;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.Function;
import org.junit.Test;

/*
 * Applies this function to the given argument
 *
 * Params:
 * t – the function argument
 * Returns:
 * the function result
 */
public class Apply_method extends AbstractUtils {

  @Test
  public void apply() {
    /*
    @FunctionalInterface
    public interface Function<T, R>

    <T> – the type of the input to the function
    <R> – the type of the result of the function
    */
    Function<String, Integer> fun =
        str -> {
          println("public interface Function<T, R>:", "Function<String, Integer> fun");
          int length = str.length();
          println("<T> input:", str, "<R> – result:", length);
          return length;
        };

    Integer apply = fun.apply("test");
    assertThat(apply).isEqualTo(4);
  }
}
