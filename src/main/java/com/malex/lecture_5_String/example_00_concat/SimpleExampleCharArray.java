package com.malex.lecture_5_String.example_00_concat;

import lombok.extern.java.Log;

/** Simple example */
@Log
public class SimpleExampleCharArray {

  public static void main(String[] args) {

    char[] arr = {'a', 'b', 'c', 'd'};
    String str = new String(arr);
    log.info(str);

    String str1 = new String(arr, 1, 3);
    log.info(str1);
  }
}
