package com.malex.lecture_7_Date.java_util.date;

import java.util.Date;
import org.junit.Test;

/*
 * Compares two Dates for ordering.
 *
 * Returns:
 * the value 0 if the argument Date is equal to this Date
 * a value less than 0 if this Date is before the Date argument
 * and a value greater than 0 if this Date is after the Date argument.
 */
public class CompareTo_method extends Date_class {

  @Test
  public void test() {
    Date now = new Date();
    int diff = now.compareTo(new Date());
    println("compareTo: ", diff);

    diff = now.compareTo(new Date(System.currentTimeMillis() - 100));
    println("compareTo: ", diff);

    diff = now.compareTo(new Date(System.currentTimeMillis() + 100));
    println("compareTo: ", diff);
  }
}
