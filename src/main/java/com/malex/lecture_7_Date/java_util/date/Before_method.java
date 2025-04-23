package com.malex.lecture_7_Date.java_util.date;

import java.util.Date;
import org.junit.Test;

/*
 * Tests if this date is before the specified date.
 *
 * Returns:
 * true if and only if the instant of time represented by this Date object is strictly earlier
 * than the instant represented by when false otherwise.
 */
public class Before_method extends Date_class {

  @Test
  public void test() {
    Date now = new Date();

    boolean before = now.before(new Date());
    println("before: ", before);

    before = now.before(new Date(System.currentTimeMillis() + 100));
    println("before: ", before);
  }
}
