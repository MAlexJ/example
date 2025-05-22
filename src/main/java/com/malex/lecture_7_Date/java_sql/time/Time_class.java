package com.malex.lecture_7_Date.java_sql.time;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/*
 * A time.
 *
 * The range is '-838:59:59.000000' to '838:59:59.000000'.
 *
 * MySQL displays TIME values in 'hh:mm:ss[.fraction]' format, but permits assignment of values to TIME columns
 * using either strings or numbers.
 *
 * MySQL comes with the following data types for storing a date or a date/time value in the database:
 *
 * - DATE - format YYYY-MM-DD
 * - DATETIME - format: YYYY-MM-DD HH:MI:SS
 * - TIMESTAMP - format: YYYY-MM-DD HH:MI:SS
 * - YEAR - format YYYY or YY
 *
 */
public class Time_class extends AbstractUtils {

  @Test
  public void createFromMilliseconds() {
    long millis = System.currentTimeMillis();
    java.sql.Time time = new java.sql.Time(millis);
    println("time: ", time);
  }

  /*
   *  Create from string
   */
  @Test
  public void createFromString() {
    java.sql.Time time = java.sql.Time.valueOf("15:45:30"); // 3:45:30 PM
    println("time: ", time);
  }
}
