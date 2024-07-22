package com.malex.lecture_15_Lambda_Functional_Interface.function.binary_functions.custom;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Simple example of using lambda expressions. */
public class LambdaExampleFunctionalInterface extends AbstractUtils {

  /** Functional interface. */
  interface OperationFunction {

    /** Functional interface must contain only a single method with no implementation. */
    int calculate(int x, int y);

    default void print(int num) {
      printlnString("result: ", Integer.toString(num));
    }
  }

  @Test
  public void calculate() {
    OperationFunction operation = Integer::sum;
    operation.print(operation.calculate(2, 4));

    OperationFunction operation1 = (int x, int y) -> x / y;
    OperationFunction operation2 = (int x, int y) -> x - y;
    OperationFunction operation3 = (int x, int y) -> x * y;

    operation.print(operation1.calculate(10, 4));
    operation.print(operation2.calculate(2, 4));
    operation.print(operation3.calculate(2, 4));
  }
}
