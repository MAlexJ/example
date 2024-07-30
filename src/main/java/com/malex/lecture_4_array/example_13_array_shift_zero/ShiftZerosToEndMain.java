package com.malex.lecture_4_array.example_13_array_shift_zero;

import static com.google.common.base.Preconditions.checkArgument;
import static org.junit.Assert.assertArrayEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;

public class ShiftZerosToEndMain extends AbstractUtils {

  @Test
  public void test() {
    int[] arr = {1, 2, 8, 0, 3, 5, 0, 0, -1, 5, 0, 0, 0, 2};
    print("result - " + Arrays.toString(moveZerosToEnd(arr)));
    print("result - " + Arrays.toString(moveZerosToEnd(new int[] {0, 1, 0, 1, 0, 1})));
  }

  private int[] moveZerosToEnd(int[] arr) {
    checkArgument(Objects.nonNull(arr), "Array is null!");
    checkArgument(arr.length != 0, "Array is empty!");
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

  @Test(expected = IllegalArgumentException.class)
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
