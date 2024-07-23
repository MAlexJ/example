package com.malex.lecture_15_Lambda_Functional_Interface.function.binary_functions;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.BinaryOperator;
import org.junit.Test;

public class BinaryOperatorSample extends AbstractUtils {

  @Test
  public void sample() {
    BinaryOperator<String> operator = (a, b) -> a + b;

    String hello = operator.apply("Hello", "World");
    println("hello: ", hello);

    assertThat(hello).isEqualTo("HelloWorld");
  }
}
