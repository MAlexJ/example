package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.predicate.custom;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

/** Lambdas passed as parameters to methods. */
public class CustomPredicateFunction extends AbstractUtils {

  /** Functional interface */
  @FunctionalInterface
  interface EvenPredicate {
    boolean isEven(int n);
  }

  @Test
  public void sumAllEvenNumbers() {
    // given
    EvenPredicate evenPredicate = n -> (n % 2 == 0);

    // when
    int sum = sum(evenPredicate, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // then
    println("Result of calculation: " + sum);
    assertEquals(30, sum);
  }

  /**
   * Sum numbers by predicate
   *
   * @param numbers array of number
   * @param predicate functional interface
   * @return the result of the calculation.
   */
  private int sum(EvenPredicate predicate, int... numbers) {
    return Arrays.stream(numbers) //
        .filter(predicate::isEven)
        .sum();
  }
}
