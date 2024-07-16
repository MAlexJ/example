package com.malex.lecture_18_programming_idiom.coupling_in_java;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * There are two types of coupling: <br>
 * <br>
 * 1. Tight coupling <br>
 * 2. Loose coupling
 *
 * <p>In general, Tight coupling means the two classes often change together. In other words, if A
 * knows more than it should about the way in which B was implemented, then A and B are tightly
 * coupled.
 */
public class TightCoupling extends AbstractUtils {

  /*
  Explanation of the above Program:

  In the above program the Subject class is dependents on Topic class.
  The Subject class is tightly coupled with Topic class it means if any change in the Topic class
  requires Subject class to change.

  For example, if Topic class understand() method change to gotit() method
  then you have to change the startReading() method will call gotit() method instead of calling understand() method.
   */
  private static class Subject {
    Topic t = new Topic();

    public void startReading() {
      t.understand();
    }
  }

  private static class Topic {
    public void understand() {
      printlnString("Tight coupling concept");
    }
  }

  @Test
  public void test() {
    var subject = new Subject();
    subject.startReading();
  }
}
