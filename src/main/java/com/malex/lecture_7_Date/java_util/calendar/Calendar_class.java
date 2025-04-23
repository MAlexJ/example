package com.malex.lecture_7_Date.java_util.calendar;

import com.malex.utils.AbstractUtils;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

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
}
