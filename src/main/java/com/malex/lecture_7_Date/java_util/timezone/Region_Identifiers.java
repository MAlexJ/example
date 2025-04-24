package com.malex.lecture_7_Date.java_util.timezone;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;

public class Region_Identifiers extends TimeZone_class {

  private SimpleDateFormat dateFormat;

  /*
   * When writing tests, it is common to find that several tests need similar objects created before they can run.
   */
  @Before
  public void init() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
  }

  /*
   * Getting Available Region Identifiers
   */
  @Test
  public void gettingAvailableRegionIdentifiers() {
    String[] zoneIds = TimeZone.getAvailableIDs();
    for (String id : zoneIds) {
      println(id);
    }
  }

  /*
   * Create TimeZone by Region ID
   */
  @Test
  public void createTimeZoneByRegionID() {
    TimeZone kievTimeZone = TimeZone.getTimeZone("Europe/Kiev");
    println("Europe/Kiev: ", kievTimeZone);

    TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
    println("Asia/Tokyo: ", tz);

    println("ID: " + tz.getID()); // Asia/Tokyo
    println("Abbreviation: " + tz.getDisplayName()); // Japan Standard Time
    println("Raw Offset (ms): " + tz.getRawOffset()); // 32400000 => +09:00
    println("Raw Offset (ms): " + tz.getRawOffset() / (1000 * 60 * 60)); // 32400000 => +09:00
  }

  /*
   * Format Output That Shows Abbreviations (from Region Identifiers)
   */
  @Test
  public void showsAbbreviationsFromRegionIdentifiers() {

    TimeZone tz = TimeZone.getTimeZone("Europe/Helsinki"); // Also EET in winter

    Calendar calendar = Calendar.getInstance(tz);

    Date date = calendar.getTime();

    dateFormat.setTimeZone(tz);
    println("Formatted date with abbreviation:", dateFormat.format(date));
  }
}
