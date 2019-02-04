package com.malex.lecture_7_Date.example01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import lombok.extern.log4j.Log4j;

@Log4j
public class GetNumberOfCurrentDay {

  public static void main(String[] args) {

    String oldestDateString = "2015-10-01 15:00:00";
    String latestDateString = "2015-12-25 14:00:00";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime oldestDate = LocalDateTime.parse(oldestDateString, formatter);
    LocalDateTime latestDate = LocalDateTime.parse(latestDateString, formatter);

    int year = oldestDate.getYear();
    int month = oldestDate.getMonthValue();
    int day = oldestDate.getDayOfMonth();
    int hours = oldestDate.getHour();
    int minutes = oldestDate.getMinute();
    int seconds = oldestDate.getSecond();

    log.debug(year);
    log.debug(month);
    log.debug(day);
    log.debug("hours:" + hours);

    // get the number of days in a month
    Calendar cal = Calendar.getInstance();
    int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    log.debug("days: " + days);

    LocalDateTime now = LocalDateTime.now();

    log.debug("now.getMonth(): " + now.getMonth());
    log.debug("now.getMonthValue(): " + now.getMonthValue());
    log.debug("now.getDayOfMonth(): " + now.getDayOfMonth());
  }
}
