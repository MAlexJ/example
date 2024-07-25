package com.malex.lecture_15_Lambda_Functional_Interface.binary_operator;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Simple example generalized functional interface. */
public class BinaryOperator_custom extends AbstractUtils {

  /*
  BinaryOperator

  link: https://www.geeksforgeeks.org/binaryoperator-interface-in-java/

  The BinaryOperator Interface<T> is a part of the java.util.function package, implement
      functional programming in Java. It represents a binary operator which takes two operands and
      operates on them to produce a result.

  However, what distinguishes it from a normal BiFunciton is that both of its arguments
    and its return type are same

   T: denotes the type of the input arguments and the return value of the operation
      The BinaryOperator<T> extends the BiFunction<T, T, T> type.
      So it inherits the following methods from the BiFunction Interface:
  */
  @FunctionalInterface
  private interface BinaryOperatorFunctionInterface<T> {
    T calculate(T x, T y);
  }

  @Test
  public void calculateBinaryOperator() {

    BinaryOperatorFunctionInterface<Integer> lmbInteger =
        (x, y) -> {
          if (x > y) return x + y;
          else return x - y;
        };

    BinaryOperatorFunctionInterface<String> lmbString =
        (x, y) -> {
          if (x.isEmpty() || y.isEmpty()) {
            return "Result empty!";
          }
          return x + y;
        };

    println("Result: ", lmbInteger.calculate(12, 14));
    println("Result: ", lmbString.calculate("start_", "finish"));
  }
}
