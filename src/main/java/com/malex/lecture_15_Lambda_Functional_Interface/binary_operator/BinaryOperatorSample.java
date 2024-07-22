package com.malex.lecture_15_Lambda_Functional_Interface.binary_operator;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import org.junit.Test;

/**
 * BinaryOperator
 *
 * <p>link: https://www.geeksforgeeks.org/binaryoperator-interface-in-java/
 *
 * <p>The BinaryOperator Interface<T> is a part of the java.util.function package, implement
 * functional programming in Java. It represents a binary operator which takes two operands and
 * operates on them to produce a result.
 */
public class BinaryOperatorSample extends AbstractUtils {

  @Test
  public void apply() {
    /*
    However, what distinguishes it from a normal BiFunciton is that both of its arguments
    and its return type are same

     T: denotes the type of the input arguments and the return value of the operation
        The BinaryOperator<T> extends the BiFunction<T, T, T> type.
        So it inherits the following methods from the BiFunction Interface:
    */
    BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
    Integer result = binaryOperator.apply(1, 2);
    println("(a, b) -> a + b :" + result);

    assertThat(result).isEqualTo(3);
  }

  @Test
  public void andThen() {
    // (first, second) -> first.concat(second) is the same String::concat;
    BinaryOperator<String> binaryOperator =
        (first, second) -> {
          String result = first.replaceAll(second, "");
          println("1.", "first =", first, "second =", second, "result = '", result, "'");
          return result;
        };

    BiFunction<String, String, Integer> biFunction =
        binaryOperator.andThen(
            (a) -> {
              int length = a.length();
              println("2. length =", length);
              return length;
            });

    Integer result = biFunction.apply("helloWord", "hello");
    println("binaryOperator.andThen((a) -> a.length()) :" + result);
  }
}
