package com.malex.lecture_15_Lambda_Functional_Interface.function.custom;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Simple example of using lambda expression. The method of functional interface without parameters.
 *
 * @author malex
 */
public class SimpleExampleLambdaExpr extends AbstractUtils {

  @Test
  public void sample() {
    IOperation operation = () -> 20 + 40;
    println(" () -> 20 + 40;  \n result: " + operation.method());

    IExample first = (x) -> x + 2;
    println(" (x) -> x + 2;  \n result: " + first.method(2));

    IExample second = x -> x * 3;
    println(" x -> x * 3;  \n result: " + second.method(2));
  }
}

/** Functional interface. */
@FunctionalInterface
interface IOperation {

  /**
   * Method without parameters.
   *
   * @return result
   */
  int method();
}

/** Functional interface. */
@FunctionalInterface
interface IExample {

  /**
   * Method has one parameter.
   *
   * @param x input value.
   * @return result calculation.
   */
  int method(int x);
}
