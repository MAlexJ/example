package com.malex.lecture_7_Date.java_util.date;

import com.malex.utils.AbstractUtils;
import java.time.Instant;
import java.util.Date;
import org.junit.Test;

/*
 * Wed Apr 23 13:16:44 EEST 2025
 * is Java-specific — it's the default output of java.util.Date.toString().
 *
 * It’s not a standard format like:
 *
 * ISO 8601 (2025-04-23T13:16:44+03:00)
 * RFC 1123 (Wed, 23 Apr 2025 13:16:44 EEST) or Unix asctime() (Wed Apr 23 13:16:44 2025)
 * It’s mostly meant for debugging or logs, not for storage or APIs.
 *
 * It includes:
 * Day of the week
 * Month name
 * Day of the month
 * Time (in local timezone)
 * Time zone abbreviation (e.g., EEST)
 * Year
 *
 * Recommendation:
 * If you need consistent formatting (e.g., for APIs or JSON), use DateTimeFormatter with LocalDateTime, ZonedDateTime, or Instant.
 */
public class Date_class extends AbstractUtils {

  @Test
  public void initialization() {

    // Date class
    Date now = new Date();
    println("Java-specific format - ", "now:", now);

    Date date = new Date(System.currentTimeMillis());
    println("Java-specific format - ", "date:", date);

    String toString = now.toString();
    println("Java-specific format - ", "date toString:", toString);

    Date from = Date.from(Instant.now());
    println("Java-specific format - ", "Date.from:", from);

    // UTC time zone
    Instant instant = now.toInstant();
    println("Java-specific format - ", "date toInstant:", instant);
  }

  @Test
  public void jan01_EET_1970() {
    Date date = new Date(1000l);
    println("Java-specific format - ", " - UTC+3: ", date);
  }
}
