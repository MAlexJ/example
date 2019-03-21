package com.malex.lecture_5_String.example_00_concat;

import lombok.extern.log4j.Log4j;

/**
 * Example of using String.concat() method. Concatenates the specified string to the end of this
 * string.
 */
@Log4j
public class StringConcatMethod {

  public static void main(String[] args) {
    String str1 = "First";
    String str2 = "Second";

    String strResult = str1.concat(str2);

    log.debug("str1 -> " + str1);
    log.debug("str2 -> " + str2);
    log.debug("strResult -> " + strResult);
  }
}
