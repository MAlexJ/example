package com.malex.lecture_4_array.example_01_array_one;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

public class InitArrayMain extends AbstractUtils {

  @Test
  public void test() {
    simpleInit();
    fastInit();
    whileLoop();
    recursive();
  }

  private void simpleInit() {
    int[] numArray = new int[5];
    numArray[0] = 1;
    numArray[1] = 2;
    numArray[2] = 3;
    numArray[3] = 4;
    numArray[4] = 5;

    // Array
    int numLength = numArray.length;

    print("numArray.length -> " + numLength);
    print(Arrays.toString(numArray));
  }

  private void fastInit() {
    int[] number = {2, 5, 7, 6};
    for (int i = 0; i < number.length; i++) {
      print("arr[i]=" + number[i]);
    }
  }

  private void whileLoop() {
    int[] number = {2, 5, 7, 6};
    int position = 0;
    while (position < number.length) {
      print("position=" + number[position]);
      position++;
    }
  }

  private void recursive() {
    int[] number = {2, 5, 7, 6};
    recursiveIteration(number, 0);
  }

  private void recursiveIteration(int[] array, int i) {
    print("elem = " + array[i]);
    i++;
    if (i < array.length) {
      recursiveIteration(array, i);
    }
  }
}
