package com.malex.lecture_5_String.base.example_01_String;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

/** Created by Alex on 2/17/2015. */
public class CreateStringFromCharArray extends AbstractUtils {

  @Test
  public void run() {

    // *****************************************
    char[] arrChar = {'a', 'b', 'c', 'd'};
    String str = new String(arrChar);
    println(str);
    assertEquals("abcd", str);

    // *****************************************
    String str1 = "System";
    char[] chars = str1.toCharArray();
    String string = Arrays.toString(chars);
    println(string);
    assertEquals("[S, y, s, t, e, m]", string);
  }
}
