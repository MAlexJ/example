package com.malex.lecture_4_array.example_13_array_shift_zero;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

public class ShiftZerosToStartMain extends AbstractUtils {

  private final int[] firstArray = {1, 4, 8, 0, 7, 5, 0, 0, -1, 5, 0, 0, 0, 2};
  private final int[] secondArray = new int[] {0, 1, 0, 8, 0, 1};

  @Test
  public void test() {
    int[] numbers = moveZerosToStart(firstArray);
    assertTrue(Arrays.equals(new int[] {0, 0, 0, 0, 0, 0, 1, 4, 8, 7, 5, -1, 5, 2}, numbers));
    println("result:", Arrays.toString(numbers));

    numbers = moveZerosToStart(secondArray);
    assertTrue(Arrays.equals(new int[] {0, 0, 0, 1, 8, 1}, numbers));
    println("result:", Arrays.toString(numbers));
  }

  private int[] moveZerosToStart(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must have values!");
    }
    int[] tmpArr = new int[arr.length];
    int position = arr.length - 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      int elem = arr[i];
      if (elem != 0) {
        tmpArr[position] = elem;
        position--;
      }
    }
    return tmpArr;
  }
}
