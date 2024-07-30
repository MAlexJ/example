package com.malex.lecture_5_String.base.example_00_concat;

import com.malex.utils.AbstractUtils;
import lombok.extern.java.Log;
import org.junit.Test;

/** Simple example */
@Log
public class SimpleConcatenating extends AbstractUtils {

  @Test
  public void test() {
    String str1 = "First";
    String str2 = "Second";
    String strResult = str1 + str2;

    print("str1 -> " + str1);
    print("str2 -> " + str2);
    print("strResult -> " + strResult);
  }
}
