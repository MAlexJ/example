package com.malex.lecture_5_String.base.example_00_concat;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/*
 * Example of using String.concat() method.
 *
 * Concatenates the specified string to the end of this string.
 */
public class StringConcatMethod extends AbstractUtils {

  /*
   * Concatenates the specified string to the end of this string.
   * If the length of the argument string is 0, then this String object is returned.
   */
  @Test
  public void test() {
    String str1 = "First";
    String str2 = "Second";

    String strResult = str1.concat(str2);

    print("str1 -> " + str1);
    print("str2 -> " + str2);
    print("strResult -> " + strResult);
  }
}
