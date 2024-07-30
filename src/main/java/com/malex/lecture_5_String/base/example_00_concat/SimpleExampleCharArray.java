package com.malex.lecture_5_String.base.example_00_concat;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Simple example */
public class SimpleExampleCharArray extends AbstractUtils {

  @Test
  public void test() {

    char[] arr = {'a', 'b', 'c', 'd'};
    String str = new String(arr);
    print(str);

    String str1 = new String(arr, 1, 3);
    print(str1);
  }
}
