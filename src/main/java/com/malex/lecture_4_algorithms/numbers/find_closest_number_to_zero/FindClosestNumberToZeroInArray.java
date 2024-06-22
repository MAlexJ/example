package com.malex.lecture_4_algorithms.numbers.find_closest_number_to_zero;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Find the Closest Number to Zero in a Java Array
 *
 * <p>link: https://www.baeldung.com/java-array-find-nearest-zero
 */
public class FindClosestNumberToZeroInArray extends AbstractUtils {

  /** For example, given the array, [1, -3, 2, -2, 4], the number closest to zero is 1. */
  @Test
  public void findClosestNumberToZeroTest() {
    int number = 1;
    assertEquals(number, findClosestNumberToZero(new int[] {number, -3, 2, -2, 4}));

    number = 2;
    assertEquals(number, findClosestNumberToZero(new int[] {4, -3, number, -number, 4}));

    number = 1;
    assertEquals(number, findClosestNumberToZero(new int[] {number, 60, -10, 70, -80, 85}));

    number = 0;
    assertEquals(number, findClosestNumberToZero(new int[] {number, 60, -10, 70, -80, 85}));
    assertEquals(number, findClosestNumberToZero(new int[] {1, 60, -10, 70, -80, number}));
    assertEquals(number, findClosestNumberToZero(new int[] {1, 60, -10, number, -80, number}));
  }

  private int findClosestNumberToZero(int[] array) {
    int first = array[0];
    for (int i = 1; i < array.length; i++) {
      if (Math.abs(array[i]) < Math.abs(first)) {
        first = array[i];
      }
    }
    return first;
  }
}
