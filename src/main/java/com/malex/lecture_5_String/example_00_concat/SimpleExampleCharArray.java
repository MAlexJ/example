package com.malex.lecture_5_String.example_00_concat;

import lombok.extern.log4j.Log4j;

/** Simple example */
@Log4j
public class SimpleExampleCharArray {

  public static void main(String[] args) {

    char[] arr = {'a', 'b', 'c', 'd'};
    String str = new String(arr);
    log.debug(str);

    String str1 = new String(arr, 1, 3);
    log.debug(str1);
  }
}
