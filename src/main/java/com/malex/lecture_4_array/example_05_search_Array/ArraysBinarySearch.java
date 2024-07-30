package com.malex.lecture_4_array.example_05_search_Array;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

/** Created by Alex on 05.06.2015. */
public class ArraysBinarySearch extends AbstractUtils {

  /*
   * Searches the specified array of ints for the specified value using the binary search algorithm.
   * The array must be sorted (as by the sort(int[]) method) prior to making this call.
   */
  @Test
  public void binarySearch() {
    // Note: The array must be sorted
    int[] array = {-8, 1, 2, 3, 6, 7, 8, 9};
    int x = 3;

    int binarySearch = Arrays.binarySearch(array, x);
    print("index of the search key -> " + binarySearch);
  }
}
