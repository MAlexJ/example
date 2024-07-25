package com.malex.lecture_15_Lambda_Functional_Interface.bi_funciton.binary_operator_extends_bi_function;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.BinaryOperator;
import org.junit.Test;

/*
 * BinaryOperator<T> extends BiFunction<T, T, T>
 *
 * Represents an operation upon two operands of the same type,
 * producing a result of the same type as the operands
 */
public class BinaryOperator_sample extends AbstractUtils {

  @Test
  public void sample() {
    BinaryOperator<String> operator = (a, b) -> a + b;

    String hello = operator.apply("Hello", "World");
    println("hello: ", hello);

    assertThat(hello).isEqualTo("HelloWorld");
  }
}
