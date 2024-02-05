package com.malex.lecture_4_array.example_15_find_unique_elements;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

public class FindUniqueElements extends AbstractUtils {

  @Test
  public void run() {
    // create an integer array having some duplicate elements
    int[] duplicates = {10, 3, 5, 3, 3, 3, 9, 22, 4, 3, 1, 5, 6};

    int[] array = Arrays.stream(duplicates).distinct().toArray();

    print(Arrays.toString(array));
  }
}
