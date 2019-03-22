package com.malex.lecture_5_String.example_01_length;

import lombok.extern.log4j.Log4j;

@Log4j
public class SampleLengthString {

  public static void main(String[] args) {
    String palindrome = "Dot saw I was Tod";
    int len = palindrome.length();

    log.debug("String Length is : " + len);
  }
}
