package com.malex.lecture_7_Date.java_util.timezone;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;

/*
 * Can You Directly Set Abbreviations like "PST"?
 *
 * Not exactly. Java's legacy API (java.util.TimeZone) does not officially support setting time zones
 * by abbreviation alone,because:
 *
 * - Abbreviations are not unique (IST = India or Israel?).
 * - Java internally maps some abbreviations to region identifiers (e.g., PST → America/Los_Angeles).
 * - Still, some abbreviations work, and you can use them as input to TimeZone.getTimeZone(String id).
 *
 *
 * Best Practices:
 * - Abbreviations can work, but they are unreliable.
 * - Use IANA region-based IDs like "Europe/Kiev" or "America/New_York" for accuracy.
 * - To convert abbreviation → region ID, use an online mapping or Java's ZoneId.getAvailableZoneIds() in modern java.time.
 */
public class Abbreviations extends TimeZone_class {

  private SimpleDateFormat dateFormat;

  /*
   * When writing tests, it is common to find that several tests need similar objects created before they can run.
   */
  @Before
  public void init() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
  }

  @Test
  public void simple() {
    Date now = new Date();

    // Show time in UTC
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    println("UTC: " + dateFormat.format(now));

    // Show time in EET
    dateFormat.setTimeZone(TimeZone.getTimeZone("EET"));
    println("EET: " + dateFormat.format(now));

    // Show time in New York
    dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

    println("New York: " + dateFormat.format(now));
  }

  /*
   * Using TimeZone with "PST" Abbreviation
   */
  @Test
  public void usingTimeZoneWithAbbreviation() {
    TimeZone tz = TimeZone.getTimeZone("PST"); // Pacific Standard Time

    dateFormat.setTimeZone(tz);

    println("Time Zone ID: " + tz.getID()); // Often returns region
    println("Formatted Time: " + dateFormat.format(new Date()));
  }

  /*
   * Ambiguous Abbreviation — "IST"
   */
  @Test
  public void ambiguousAbbreviation() {

    /*
     * Warning:
     *
     * "IST" usually resolves to India Standard Time (Asia/Kolkata), but it's ambiguous.
     * Always prefer region identifiers like "Asia/Kolkata" instead.
     */
    TimeZone tz = TimeZone.getTimeZone("IST"); // India OR Israel?

    println("Time Zone ID: " + tz.getID());
    println("Offset (ms): " + tz.getRawOffset());
    println("Offset (ms): " + tz.getRawOffset() / (1000 * 60 * 60));
  }
}
