package com.malex.lecture_5_String.base.example_02_equals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class StringEqualsIgnoreCase extends AbstractUtils {

  @Test
  public void test() {
    String str1 = new String("This is really not immutable!!");
    String str3 = new String("This is really not immutable!!");
    String str4 = new String("This IS REALLY NOT IMMUTABLE!!");
    boolean retVal;

    retVal = str1.equals(str3);
    print("str1.equals( str3 ) = " + retVal);

    retVal = str1.equals(str4);
    print("str1.equals( str4 ) = " + retVal);

    retVal = str1.equalsIgnoreCase(str4);
    print("str1.equalsIgnoreCase( str4  = " + retVal);
  }
}
