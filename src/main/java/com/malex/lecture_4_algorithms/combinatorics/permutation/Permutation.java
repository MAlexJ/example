package com.malex.lecture_4_algorithms.combinatorics.permutation;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

/**
 * permutation:
 *
 * <p>In mathematics, a permutation of a set can mean one of two different things: <br>
 * 1. an arrangement of its members in a sequence or linear order, or <br>
 * 2. the act or process of changing the linear order of an ordered set
 *
 * <p>n - elements > 1 * 2 * 3 * 4 * .... n = n!
 *
 * <p>link https://en.wikipedia.org/wiki/Permutation
 */
public class Permutation extends AbstractUtils {

  @Test
  public void test() {
    assertEquals(1, calculatePermutationOfNumberSet(List.of(2)));
    assertEquals(2, calculatePermutationOfNumberSet(List.of(7, 9)));
    assertEquals(6, calculatePermutationOfNumberSet(List.of(4, 6, 8)));
    assertEquals(24, calculatePermutationOfNumberSet(List.of(2, 4, 6, 8)));
  }

  /** Calculate the possible permutation of a set of numbers */
  public int calculatePermutationOfNumberSet(List<Integer> numbers) {
    println("Numbers:", numbers);
    int size = numbers.size();
    return factorial(size);
  }

  private int factorial(int num) {
    int temp = 1;
    for (int i = 1; i <= num; i++) {
      temp = temp * i;
    }
    return temp;
  }
}
