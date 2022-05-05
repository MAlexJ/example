package com.malex.lecture_5_String.example_01_length;

import lombok.extern.java.Log;

@Log
public class SampleLengthString {

  public static void main(String[] args) {
    String palindrome = "Dot saw I was Tod";
    int len = palindrome.length();

    log.info("String Length is : " + len);
  }
}
