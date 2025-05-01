package com.malex.lecture_7_Date.java_sql.time;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/*
 * SQL DATE
 * link: https://www.w3schools.com/sql/sql_dates.asp
 *
 * MySQL comes with the following data types for storing a date or a date/time value in the database:
 *
 * - DATE - format YYYY-MM-DD
 * - DATETIME - format: YYYY-MM-DD HH:MI:SS
 * - TIMESTAMP - format: YYYY-MM-DD HH:MI:SS
 * - YEAR - format YYYY or YY
 *
 * SQL Server comes with the following data types for storing a date or a date/time value in the database:
 *
 * - DATE - format YYYY-MM-DD
 * - DATETIME - format: YYYY-MM-DD HH:MI:SS
 * - SMALLDATETIME - format: YYYY-MM-DD HH:MI:SS
 * - TIMESTAMP - format: a unique number
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
