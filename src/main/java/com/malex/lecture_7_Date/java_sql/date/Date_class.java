package com.malex.lecture_7_Date.java_sql.date;

import com.malex.utils.AbstractUtils;
import java.time.Instant;
import java.time.LocalDate;
import org.junit.Test;

/*
 * SQL DATE
 *
 * The supported range is '1000-01-01' to '9999-12-31'.
 *
 * MySQL displays DATE values in 'YYYY-MM-DD' format, but permits assignment of values to DATE columns
 * using either strings or numbers.
 *
 * link: https://dev.mysql.com/doc/refman/8.4/en/date-and-time-type-syntax.html
 *
 * MySQL comes with the following data types for storing a date or a date/time value in the database:
 *
 * link: https://www.w3schools.com/sql/sql_dates.asp
 *
 * - DATE - format YYYY-MM-DD
 * - DATETIME - format: YYYY-MM-DD HH:MI:SS
 * - TIMESTAMP - format: YYYY-MM-DD HH:MI:SS
 * - YEAR - format YYYY or YY
 *  */
public class Date_class extends AbstractUtils {

  @Test
  public void createFromString() {
    java.sql.Date sqlDate = java.sql.Date.valueOf("2025-04-30");
    println("sqlDate:", sqlDate);
  }

  @Test
  public void createFromMilliseconds() {
    long millis = System.currentTimeMillis();
    java.sql.Date sqlDate = new java.sql.Date(millis);
    println("sqlDate: ", sqlDate);
  }

  @Test
  public void createFromLocalDate() {
    LocalDate localDate = LocalDate.now();
    java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
    println("sqlDate:", sqlDate);
  }

  @Test
  public void convertToLocalDate() {
    java.sql.Date sqlDate = java.sql.Date.valueOf("2025-04-30");
    LocalDate date = sqlDate.toLocalDate();
    println("LocalDate:", date);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void convertToInstant() {
    java.sql.Date sqlDate = java.sql.Date.valueOf("2025-04-30");
    Instant instant = sqlDate.toInstant();
  }
}
