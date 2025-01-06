package com.malex.lecture_12_var;

import org.junit.Test;

/*
 * Q7. Why can’t you use var with null?
 *
 * link: https://openjdk.org/projects/amber/guides/lvti-faq
 *
 * Consider this declaration (which is illegal):
 *
 * var person = null; // ERROR
 *
 * The null literal denotes a value of a special null type (JLS 4.1) that is the subtype of all reference types in Java.
 * The only value of the null type is null itself, therefore, the only value that could ever be assigned
 * to a variable of the null type is null.
 * This isn’t very useful.
 */
public class LVTI_and_null {

  @Test
  public void run() {

    // var person = null; // ERROR
  }
}
