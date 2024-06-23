package com.malex.lecture_4_algorithms.numbers.find_closest_number_to_zero;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

abstract class TestImpl extends AbstractUtils {

  abstract int findClosestNumberToZero(int[] array);

  @Test
  public void test() {
    println("Start test");
    int number = 1;
    assertEquals(number, findClosestNumberToZero(new int[] {number, -3, 2, -2, 4}));

    number = 2;
    assertEquals(number, findClosestNumberToZero(new int[] {4, -3, number, 5, 4}));

    number = 1;
    assertEquals(number, findClosestNumberToZero(new int[] {number, 60, -10, 70, -80, 85}));

    number = 0;
    assertEquals(number, findClosestNumberToZero(new int[] {number, 60, -10, 70, -80, 85}));
    assertEquals(number, findClosestNumberToZero(new int[] {1, 60, -10, 70, -80, number}));
    assertEquals(number, findClosestNumberToZero(new int[] {1, 60, -10, number, -80, number}));
    println("End test");
  }
}
