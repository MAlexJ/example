package com.malex.lecture_13_generic.wildcard;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.ToDoubleFunction;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class WildcardSample {

  private static final String ERROR_MESSAGE = "Can't parse `%s` value";
  private static final String ERROR_MESSAGE_NRE = "List of elements is null";

  /** The main method */
  private double calculateSum(List<?> numbers) {
    Objects.requireNonNull(numbers, ERROR_MESSAGE_NRE);
    return numbers.stream()
        .filter(num -> !Objects.isNull(num))
        .mapToDouble(getToDoubleFunction())
        .sum();
  }

  private ToDoubleFunction<? super Object> getToDoubleFunction() {
    return num -> {
      if (num instanceof String) {
        return Double.parseDouble(String.valueOf(num));
      } else if (num instanceof Number) {
        return Double.parseDouble(String.valueOf(num));
      } else {
        throw new IllegalArgumentException(String.format(ERROR_MESSAGE, num.toString()));
      }
    };
  }

  @Test
  public void test() {
    log.info("Start tests >>>> ");
    assertEquals(calculateSum(Arrays.asList(1, 2, 3, 4, 5)), 15.0);
    assertEquals(calculateSum(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)), 15.0);
    assertEquals(calculateSum(Arrays.asList("1", "2.1", "35", "0")), 38.1);

    assertEquals(calculateSum(Arrays.asList(null, 2, 3, 1, null)), 6.0);
    assertEquals(calculateSum(new ArrayList<>()), 0.0);

    try {
      calculateSum(Arrays.asList("notNumber", "2.1", "35", "0"));
      fail();
    } catch (NumberFormatException e) {
      // ignore
    }

    try {
      calculateSum(null);
      fail();
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), ERROR_MESSAGE_NRE);
    }

    assertEquals(calculateSum(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0)), -1.0);
    assertEquals(calculateSum(Arrays.asList(Byte.MAX_VALUE, Byte.MIN_VALUE, 0)), -1.0);

    double infiniteVal = calculateSum(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, 0));
    assertTrue(Double.isInfinite(infiniteVal));
  }
}
