package com.malex.lecture_5_String.base.example_02_equals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class SrtingEquals extends AbstractUtils {

  @Test
  public void stringPoolVsReference() {

    String str1 = new String("Dog");

    String str2 = "Dog";

    String str3 = "Dog";

    print("str1.equals(str2) -> " + str1.equals(str2));
    print("str1==str2 -> " + (str1 == str2));
    print("str2==str3 -> " + (str2 == str3));
  }
}
