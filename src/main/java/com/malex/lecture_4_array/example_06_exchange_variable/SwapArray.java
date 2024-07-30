package com.malex.lecture_4_array.example_06_exchange_variable;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

public class SwapArray extends AbstractUtils {

  private static final int[] ARRAY = new int[2];

  @Test
  public void test() {
    ARRAY[0] = 34;
    ARRAY[1] = 56;
    print("before - " + Arrays.toString(ARRAY));

    swap(ARRAY);
    print("after - " + Arrays.toString(ARRAY));
  }

  private void swap(int[] array) {
    int result = array[0];
    array[0] = array[1];
    array[1] = result;
  }
}
