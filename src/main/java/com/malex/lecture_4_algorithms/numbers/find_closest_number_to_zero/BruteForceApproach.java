package com.malex.lecture_4_algorithms.numbers.find_closest_number_to_zero;

/**
 * The Brute Force Approach
 *
 * <p>This method involves a straightforward iteration through the array, calculating the absolute
 * difference between each element and zero, and keeping track of the minimum difference encountered
 * so far
 */
public class BruteForceApproach extends TestImpl {

  @Override
  int findClosestNumberToZero(int[] array) {
    int first = array[0];
    for (int i = 1; i < array.length; i++) {
      if (Math.abs(array[i]) < Math.abs(first)) {
        first = array[i];
      }
    }
    return first;
  }
}
