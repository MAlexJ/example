package com.malex.lecture_7_Date.java_sql.timestamp;

import com.malex.utils.AbstractUtils;
import java.sql.Timestamp;
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
public class Timestamp_class extends AbstractUtils {

  @Test
  public void createFromMilliseconds() {
    long millis = System.currentTimeMillis();
    Timestamp ts = new Timestamp(millis);
    println("ts: ", ts);
  }

  @Test
  public void createFromString() {
    Timestamp ts = Timestamp.valueOf("2025-04-30 15:45:30");
    println("ts: ", ts);
  }
}
