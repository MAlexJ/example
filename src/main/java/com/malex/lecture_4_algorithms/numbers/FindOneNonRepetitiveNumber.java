package com.malex.lecture_4_algorithms.numbers;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

public class FindOneNonRepetitiveNumber extends AbstractUtils {

  private static final List<int[]> NUMBER_ARRAYS =
      List.of(
          new int[] {1, 1, 3, 2, 2},
          new int[] {3, 1, 1, 2, 2},
          new int[] {2, 1, 2, 1, 3},
          new int[] {2, 3, 2, 1, 1},
          new int[] {2, 2, 3, 1, 1},
          new int[] {-2, -2, 3, 1, 1});

  @Test
  public void run() {
    for (var arr : NUMBER_ARRAYS) {
      // O(n^2)
      assertEquals(3, hashSetSolution(arr));
      // O(n)
      assertEquals(3, hashSetSolutionRemoveOrAdd(arr));
      // O(n^2)
      assertEquals(3, hashSetSumElementsSolution(arr));
      //  O(n)
      assertEquals(3, xorSolution(arr));
      //  O(n)
      assertEquals(3, xorStreamSolution(arr));
    }
  }

  // solution: O(n)
  private int xorSolution(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length; i++) {
      temp ^= arr[i];
    }
    return temp;
  }

  // solution: O(n)
  private int xorStreamSolution(int[] arr) {
    return Arrays.stream(arr).reduce((f, s) -> f ^ s).orElseThrow();
  }

  // solution: O(n)
  private int hashSetSolutionRemoveOrAdd(int[] arr) {
    var numbers = new HashSet<Integer>();
    for (Integer num : arr) {
      if (numbers.contains(num)) {
        numbers.remove(num);
      } else {
        numbers.add(num);
      }
    }
    return numbers.iterator().next();
  }

  // solution: O(n^2)
  private int hashSetSolution(int[] arr) {
    var result = new ArrayList<Integer>();
    var numbers = new HashSet<Integer>();
    for (Integer num : arr) {
      boolean isElementOnSet = numbers.add(num);
      if (isElementOnSet) {
        result.add(num);
      } else {
        result.remove(num);
      }
    }
    return result.getFirst();
  }

  // solution: O(n^2)
  private int hashSetSumElementsSolution(int[] arr) {
    int sum = 0;
    var unique = new HashSet<Integer>();
    for (Integer num : arr) {
      if (unique.add(num)) {
        sum += num;
      } else {
        sum -= num;
      }
    }
    return sum;
  }
}
