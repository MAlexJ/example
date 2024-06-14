package com.malex.lecture_5_String_pool;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Link to video: https://www.youtube.com/watch?v=tz-Mqc7Nw3k */
public class StringPool extends AbstractUtils {
  @Test
  public void stringPoolRefs() {
    String str1 = "Hello!";
    String str2 = "Hello!";
    String str3 = new String("Hello!");
    String str4 = new String("Hello!");

    assertTrue(str1 == str2);
    assertTrue(str1 != str3);
    assertTrue(str1 != str4);
    assertTrue(str3 != str4);
  }

  /**
   * intern method
   *
   * <p>Returns a canonical representation for the string object. A pool of strings, initially
   * empty, is maintained privately by the class
   */
  @Test
  public void internMethod() {
    String str1 = "Hello!";
    String str2 = "Hello!";
    String str3 = new String("Hello!").intern();
    String str4 = new String("Hello!").intern();

    assertTrue(str1 == str2);
    assertTrue(str1 == str3);
    assertTrue(str1 == str4);
    assertTrue(str3 == str4);
  }
}
