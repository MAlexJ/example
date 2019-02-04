package com.malex.lecture_13_generic.exampe_limited_types_extends;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

/** A simple example of using limited types of generic */
public class LimitedTypesGeneric {

  @Test
  public void test() {
    Integer[] arrayFirst = {1, 2, 3, 4, 5};
    Stats<Integer> statsFirst = new Stats<>(arrayFirst);

    Double[] arraySecond = {1.0, 2.0, 3.0, 4.0, 5.0};
    Stats<Double> statsSecond = new Stats<>(arraySecond);

    assertEquals(statsFirst.average(), statsSecond.average());
  }

  /** The class contains a limited type of generic as `extends Number` */
  @Getter
  @AllArgsConstructor
  private static class Stats<T extends Number> {
    // default value
    private static final double DEFAULT_VALUE = 0;

    private T[] array;

    double average() {
      return Arrays.stream(array).mapToDouble(Number::doubleValue).average().orElse(DEFAULT_VALUE);
    }
  }
}
