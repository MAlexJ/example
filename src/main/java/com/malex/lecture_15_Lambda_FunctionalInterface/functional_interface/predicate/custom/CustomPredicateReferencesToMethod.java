package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.predicate.custom;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

/** References to the method as the method parameters */
public class CustomPredicateReferencesToMethod extends AbstractUtils {

  @Test
  public void sample() {
    int[] nums = {-5, -3, -1, 0, 1, 2, 3, 4, 5};

    MyPredicate expr = ExpressionHelper::isEven;

    int result = sum(nums, expr);
    println("Even numbers sum:", result);
    assertEquals(6, result);

    // Link to method passed in form class_name :: static_method
    expr = ExpressionHelper::isPositive;
    result = sum(nums, expr);
    println("Positive number sum:", result);
    assertEquals(15, result);

    // object_class :: method_name (if the method is non-static)
    expr = new ExpressionNewHelper()::isEqualsFive;
    result = sum(nums, expr);
    println("Equals to five number sum:", result);
    assertEquals(5, result);
  }

  private int sum(int[] numbers, MyPredicate predicate) {
    return Arrays.stream(numbers) //
        .filter(predicate::test)
        .sum();
  }

  /** Functional interface */
  @FunctionalInterface
  private interface MyPredicate {
    boolean test(int n);
  }

  /** Class with non-static method */
  private static class ExpressionNewHelper {

    private static final int NUM = 5;

    boolean isEqualsFive(int num) {
      return num == NUM;
    }
  }

  /** Class with static method */
  private static class ExpressionHelper {

    static boolean isEven(int n) {
      return n % 2 == 0;
    }

    static boolean isPositive(int n) {
      return n > 0;
    }
  }
}
