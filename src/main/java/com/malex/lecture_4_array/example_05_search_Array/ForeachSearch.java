package com.malex.lecture_4_array.example_05_search_Array;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Created by Alex on 05.06.2015. */
public class ForeachSearch extends AbstractUtils {

  @Test
  public void test() {
    int[] array = {1, 2, 3, 6, 7, 8, 9};
    int x = 3;

    for (int item : array) {
      if (item == x) {
        print("elem = " + x);
        return;
      }
    }
  }
}
