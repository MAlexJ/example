package com.malex.lecture_5_String.substring;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class Substring extends AbstractUtils {

  /**
   * Returns a string that is a substring of this string. The substring begins with the character at
   * the specified index and extends to the end of this string. Examples:
   *
   * <pre>
   *     "unhappy".substring(2) returns "happy"
   *     "Harbison".substring(3) returns "bison"
   *     "emptiness".substring(9) returns "" (an empty string)
   * </pre>
   *
   * Params: beginIndex – the beginning index, inclusive.
   */
  @Test
  public void substring() {
    var substring = new String("a_b_c_d_e_f_g").substring(5);
    println("test:", substring);
    assertEquals("_d_e_f_g", substring);

    substring = new String("a_b_c_d_e_f_g").substring(0);
    println("test:", substring);
    assertEquals("a_b_c_d_e_f_g", substring);

    int length = new String("a_b_c_d_e_f_g").length();
    substring = new String("a_b_c_d_e_f_g").substring(length);
    println("test:", substring, "length:", length);
    assertEquals("", substring);
  }

  /**
   * Returns a string that is a substring of this string
   *
   * <pre>
   *     "unhappy".substring(2) returns "happy"
   *     "Harbison".substring(3) returns "bison"
   *     "emptiness".substring(9) returns "" (an empty string)
   * </pre>
   *
   * Params:<br>
   * beginIndex – the beginning index, inclusive <br>
   * endIndex – the ending index, exclusive
   */
  @Test
  public void substringBeginAndEndIndex() {
    var substring = new String("0_2_4_6_8_").substring(5, 6);
    println("test:", substring);
    assertEquals("_", substring);

    substring = new String("0_2_4_6_8_").substring(5, 5);
    println("test:", substring);
    assertEquals("", substring);
  }
}
