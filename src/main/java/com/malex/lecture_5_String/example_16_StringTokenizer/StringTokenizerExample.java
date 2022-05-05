package com.malex.lecture_5_String.example_16_StringTokenizer;

import java.util.Arrays;
import java.util.StringTokenizer;
import lombok.extern.java.Log;

@Log
public class StringTokenizerExample {

  private static final String STRING = "1:23:4:546:21:0:3";

  public static void main(String[] args) {

    StringTokenizer stk = new StringTokenizer(STRING, ":");

    String[] ar = new String[stk.countTokens()];

    for (int i = 0; i < ar.length; i++) {
      ar[i] = stk.nextToken();
    }

    log.info(Arrays.toString(ar));
  }
}
