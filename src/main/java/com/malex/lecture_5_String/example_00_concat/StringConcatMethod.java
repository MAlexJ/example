package com.malex.lecture_5_String.example_00_concat;

import lombok.extern.java.Log;

/**
 * Example of using String.concat() method. Concatenates the specified string to the end of this
 * string.
 */
@Log
public class StringConcatMethod {

  public static void main(String[] args) {
    String str1 = "First";
    String str2 = "Second";

    String strResult = str1.concat(str2);

    log.info("str1 -> " + str1);
    log.info("str2 -> " + str2);
    log.info("strResult -> " + strResult);
  }
}
