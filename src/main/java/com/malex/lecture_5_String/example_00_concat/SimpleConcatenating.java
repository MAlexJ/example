package com.malex.lecture_5_String.example_00_concat;

import lombok.extern.log4j.Log4j;

/** Simple example */
@Log4j
public class SimpleConcatenating {

  public static void main(String[] args) {
    String str1 = "First";
    String str2 = "Second";
    String strResult = str1 + str2;

    log.debug("str1 -> " + str1);
    log.debug("str2 -> " + str2);
    log.debug("strResult -> " + strResult);
  }
}
