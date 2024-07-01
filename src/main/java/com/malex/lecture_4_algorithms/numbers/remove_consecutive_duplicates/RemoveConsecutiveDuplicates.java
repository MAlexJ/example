package com.malex.lecture_4_algorithms.numbers.remove_consecutive_duplicates;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.Test;

/** Remove consecutive (sequential) duplicates from an ArrayList in Java */
public class RemoveConsecutiveDuplicates extends AbstractUtils {

  /**
   * Exclude duplicates in sequential
   *
   * <p>example: input {1, 1, 1, 2, 3 } -> output { 1, 2, 3 }
   */
  public List<Integer> excludeConsecutiveDuplicates(List<Integer> input) {
    if (Objects.isNull(input) || input.isEmpty()) {
      throw new RuntimeException("The list cannot be null or empty!");
    }

    // 1. create result collection
    var numbers = new ArrayList<Integer>();

    // 2. add first element to list
    numbers.add(input.getFirst());

    // 3. Iterate the remaining values started from second element
    for (int i = 1; i < input.size(); i++) {

      // 4. Compare previous with current value
      if (!input.get(i - 1).equals(input.get(i))) {

        // 45. add number to list
        numbers.add(input.get(i));
      }
    }
    return numbers;
  }

  @Test
  public void test() {
    assertEquals(
        List.of(1, 2, 3, 4, 5, 6, 7),
        excludeConsecutiveDuplicates(List.of(1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 6, 7)));
    assertEquals(
        List.of(1, 2, 3, 4, 3, 2, 1),
        excludeConsecutiveDuplicates(List.of(1, 1, 1, 1, 2, 3, 3, 3, 4, 3, 2, 2, 1)));
    assertEquals(
        List.of(1, 2, 3, 4, 3, 2, 1),
        excludeConsecutiveDuplicates(List.of(1, 1, 1, 1, 2, 3, 3, 3, 4, 3, 2, 2, 1, 1, 1)));
    assertEquals(List.of(1), excludeConsecutiveDuplicates(List.of(1, 1, 1, 1, 1, 1, 1)));
    assertEquals(
        List.of(1, 0),
        excludeConsecutiveDuplicates(List.of(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
  }
}
