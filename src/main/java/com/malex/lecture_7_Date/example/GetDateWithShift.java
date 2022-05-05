package com.malex.lecture_7_Date.example;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import lombok.extern.java.Log;
import org.junit.Test;

/** @author malex */
@Log
public class GetDateWithShift {
  /** Date format "yyyy-MM-dd" yyyy-MM-dd HH:mm:ss */
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * Get date with shift.
   *
   * @param shiftBack the shift date
   * @param checkInDate specified date
   * @return the date in format "yyyy-MM-dd"
   */
  private static String getDateWithShiftBack(int shiftBack, String checkInDate) {
    try {
      Calendar cal = Calendar.getInstance();
      // DATE - day
      int back = -shiftBack;
      cal.setTime(DATE_FORMAT.parse(checkInDate));
      cal.add(Calendar.DATE, back);
      return DATE_FORMAT.format(cal.getTime());
    } catch (ParseException e) {
      log.severe("ParseException " + e.getMessage());
      return "";
    }
  }

  @Test
  public void test() {
    // 2016-10-10 11:12:30
    String dateWithShiftBack = getDateWithShiftBack(1, "2016-10-10 11:12:30");
    log.info(dateWithShiftBack);
    assertEquals("2016-10-09 11:12:30", dateWithShiftBack);

    // UP Limit 2016-10-10 00:00:01
    dateWithShiftBack = getDateWithShiftBack(1, "2016-10-10 00:00:01");
    log.info(dateWithShiftBack);
    assertEquals("2016-10-09 00:00:01", dateWithShiftBack);

    // DOWN Limit 2016-10-10 23:23:59
    dateWithShiftBack = getDateWithShiftBack(1, "2016-10-10 23:59:59");
    log.info(dateWithShiftBack);
    assertEquals("2016-10-09 23:59:59", dateWithShiftBack);

    // Limit 2016-10-10 00:00:00
    dateWithShiftBack = getDateWithShiftBack(1, "2016-10-10 00:00:00");
    log.info(dateWithShiftBack);
    assertEquals("2016-10-09 00:00:00", dateWithShiftBack);

    // Limit 2016-10-10 24:00:00 -> 2016-10-10
    dateWithShiftBack = getDateWithShiftBack(1, "2016-10-10 24:00:00");
    log.info(dateWithShiftBack);
    assertEquals("2016-10-10 00:00:00", dateWithShiftBack);
  }
}
