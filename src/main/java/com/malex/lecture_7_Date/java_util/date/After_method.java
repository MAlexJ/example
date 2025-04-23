package com.malex.lecture_7_Date.java_util.date;

import java.util.Date;
import org.junit.Test;

/*
 * Tests if this date is after the specified date.
 *
 * Returns:
 * true if and only if the instant represented by this Date object is strictly later than the instant
 * represented by when false otherwise.
 */
public class After_method extends Date_class {

  @Test
  public void test() {
    Date now = new Date();

    boolean after = now.after(new Date());
    println("after: ", after);

    after = now.after(new Date(System.currentTimeMillis() - 100));
    println("after: ", after);
  }
}
