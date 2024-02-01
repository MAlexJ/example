package com.malex.lecture_5_String.base.example_00_concat;

import lombok.extern.java.Log;

/** Simple example */
@Log
public class SimpleConcatenating {

  public static void main(String[] args) {
    String str1 = "First";
    String str2 = "Second";
    String strResult = str1 + str2;

    log.info("str1 -> " + str1);
    log.info("str2 -> " + str2);
    log.info("strResult -> " + strResult);
  }
}
