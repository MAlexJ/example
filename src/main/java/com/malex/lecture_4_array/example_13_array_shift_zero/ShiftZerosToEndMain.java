package com.malex.lecture_4_array.example_13_array_shift_zero;

import static org.junit.Assert.assertArrayEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;

public class ShiftZerosToEndMain extends AbstractUtils {

  private final int[] firstArray = new int[] {1, 2, 8, 0, 3, 5, 0, 0, -1, 5, 0, 0, 0, 2};
  private final int[] secondArray = new int[] {0, 1, 0, 8, 0, 1};

  @Test
  public void test() {
    println("result:", Arrays.toString(moveZerosToEnd(firstArray)));
    println("result:", Arrays.toString(moveZerosToEnd(secondArray)));
  }

  private int[] moveZerosToEnd(int[] arr) {
    Objects.requireNonNull(arr, "Array is null!");
    if (arr.length == 0) {
      throw new IllegalArgumentException("Array is empty!");
    }
    int[] tmp = new int[arr.length];
    int position = 0;
    for (int elem : arr) {
      if (elem == 0) {
        continue;
      }
      tmp[position] = elem;
      position++;
    }
    return tmp;
  }

  @Test(expected = NullPointerException.class)
  public void testNull() {
    int[] arr = null;
    moveZerosToEnd(arr);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmpty() {
    moveZerosToEnd(new int[] {});
  }

  @Test
  public void testStart() {
    int[] arr = moveZerosToEnd(new int[] {0, 0, 0, 0, 1, 1, 1});
    assertArrayEquals(new int[] {1, 1, 1, 0, 0, 0, 0}, arr);
  }

  @Test
  public void testEnd() {
    int[] arr = moveZerosToEnd(new int[] {1, 1, 1, 0, 0, 0, 0});
    assertArrayEquals(new int[] {1, 1, 1, 0, 0, 0, 0}, arr);
  }
}
