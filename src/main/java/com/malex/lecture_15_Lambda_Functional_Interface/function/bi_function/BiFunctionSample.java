package com.malex.lecture_15_Lambda_Functional_Interface.function.bi_function;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.BiFunction;
import org.junit.Test;

/*
 * BiFunction<T, U, R> - Represents a function that accepts two arguments and produces a result.
 * This is the two-arity specialization of Function.
 *
 * Type parameters:
 * <T> – the type of the first argument to the function
 * <U> – the type of the second argument to the function
 * <R> – the type of the result of the function
 */
public class BiFunctionSample extends AbstractUtils {

  @Test
  public void test() {
    BiFunction<String, Integer, Double> biFunction =
        (a, b) -> {
          String string = Integer.toString(a.length() + b);
          return Double.parseDouble(string);
        };

    Double result = biFunction.apply("Hello", 5);
    print("result:", result);
    assertThat(result).isEqualTo(10.0);
  }
}
