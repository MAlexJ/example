package com.malex.lecture_5_String.example_02_equals;

import lombok.extern.java.Log;

@Log
public class StringEqualsIgnoreCase {

  public static void main(String args[]) {
    String str1 = new String("This is really not immutable!!");
    String str3 = new String("This is really not immutable!!");
    String str4 = new String("This IS REALLY NOT IMMUTABLE!!");
    boolean retVal;

    retVal = str1.equals(str3);
    log.info("str1.equals( str3 ) = " + retVal);

    retVal = str1.equals(str4);
    log.info("str1.equals( str4 ) = " + retVal);

    retVal = str1.equalsIgnoreCase(str4);
    log.info("str1.equalsIgnoreCase( str4  = " + retVal);
  }
}
