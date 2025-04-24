package com.malex.lecture_7_Date.java_util.timezone;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;

public class UTC_Offsets extends TimeZone_class {

  private SimpleDateFormat dateFormat;

  @Before
  public void init() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
  }

  @Test
  public void basicRule() {
    // You can define a time zone with a fixed UTC offset using the format:
    TimeZone tz = TimeZone.getTimeZone("GMT+03:00");
    println("tz: ", tz);
  }

  /*
   * Use different offsets
   */
  @Test
  public void applyOffsetBasedTimeZone() {
    // UTC+2 (e.g. for Eastern European Time)
    TimeZone tz = TimeZone.getTimeZone("GMT+02:00");

    // set the time zone for the SimpleDateFormat object
    dateFormat.setTimeZone(tz);

    // print the current time in UTC+2
    println("Offset ID: " + tz.getID());

    // print the current time in UTC+2
    println("Current Time in UTC+2: " + dateFormat.format(new Date()));
  }

  /*
   * Use different offsets
   */
  @Test
  public void useDifferentOffsets() {
    TimeZone utcMinus8 = TimeZone.getTimeZone("GMT-08:00"); // PST
    TimeZone utcPlus530 = TimeZone.getTimeZone("GMT+05:30"); // India

    println("PST offset (ms): " + utcMinus8);
    println("PST offset (ms): " + utcMinus8.getRawOffset());
    println("IST offset (ms): " + utcPlus530);
    println("IST offset (ms): " + utcPlus530.getRawOffset());
  }

  /*
   * Convert Date between offsets
   */
  @Test
  public void convertDateBetweenOffsets() {
    Date now = new Date();

    TimeZone utc = TimeZone.getTimeZone("GMT");
    dateFormat.setTimeZone(utc);
    println("Time in UTC: " + dateFormat.format(now));

    TimeZone india = TimeZone.getTimeZone("GMT+05:30");
    dateFormat.setTimeZone(india);
    println("Time in India: " + dateFormat.format(now));
  }

  /*
   * Get hour offset from milliseconds
   */
  @Test
  public void getHourOffsetFromMilliseconds() {
    int offsetMs = TimeZone.getTimeZone("GMT+03:00").getRawOffset();
    int offsetHours = offsetMs / (1000 * 60 * 60);

    println("Offset in hours: " + offsetHours); // 3
  }

  /*
   * Set offset in Calendar
   */
  @Test
  public void setOffsetInCalendar() {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-05:00"));
    calendar.setTime(new Date());
    println("Hour of day in UTC-5: " + calendar.get(Calendar.HOUR_OF_DAY));
  }
}
