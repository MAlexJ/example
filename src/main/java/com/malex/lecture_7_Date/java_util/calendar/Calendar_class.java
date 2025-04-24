package com.malex.lecture_7_Date.java_util.calendar;

import com.malex.utils.AbstractUtils;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/*
 * The Calendar API in Java (from the java.util package) is part of the legacy date and time system (prior to Java 8).
 * It was introduced to handle date and time manipulation more flexibly than the older Date class.
 *
 * Pitfalls:
 * MONTH is 0-based (January = 0), which often causes bugs.
 * Calendar is mutable — changes affect the same instance.
 * Thread-unsafe: don't share Calendar between threads unless synchronized.
 */
public class Calendar_class extends AbstractUtils {

  @Test
  public void test() {
    Calendar calendar = Calendar.getInstance();
    Date currentDay = calendar.getTime();
    println("Current Date: " + currentDay);

    Date startDay = getStartOfDay(currentDay);
    Date endDay = getEndOfDay(currentDay);

    println("Start day: " + startDay);
    println("End day: " + endDay);
  }

  /*
   * The following function is to get Start Time Date Object of a day:
   *
   * Input : Tuesday May 13, 2014 12:45:45 Output : Tuesday May 13, 2014 00:00:00
   *
   * @param date current date
   * @return start date of day
   */
  private Date getStartOfDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /*
   * The following function is to get End Time Date Object of a day:
   *
   * Input : Tuesday May 13, 2014 12:45:45 Output : Tuesday May 13, 2014 23:59:59
   *
   * @param date current day
   * @return end date of day
   */
  private Date getEndOfDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }

  /*
   * Get specific fields
   */
  @Test
  public void getSpecificFields() {
    Calendar calendar = Calendar.getInstance();

    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH); // 0-based
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    println("Date: " + year + "-" + (month + 1) + "-" + day);

    println(calendar.get(Calendar.AM_PM));
  }

  /*
   * Calendar.AM_PM is a field constant in the Calendar class that represents whether the time is in the morning (AM)
   * or afternoon/evening (PM) when using a 12-hour clock format.
   */
  @Test
  public void amPmTest() {
    Calendar calendar = Calendar.getInstance();
    /*
     * It can have one of two possible values:
     * Calendar.AM = 0
     * Calendar.PM = 1
     * You typically use it when working with Calendar.HOUR (12-hour format), not with Calendar.HOUR_OF_DAY (24-hour format).
     */
    int amPm = calendar.get(Calendar.AM_PM);
    println("am-pm: ", amPm);
  }
}
