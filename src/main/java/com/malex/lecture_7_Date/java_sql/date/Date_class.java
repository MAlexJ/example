package com.malex.lecture_7_Date.java_sql.date;

import com.malex.utils.AbstractUtils;
import java.time.Instant;
import java.time.LocalDate;
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
