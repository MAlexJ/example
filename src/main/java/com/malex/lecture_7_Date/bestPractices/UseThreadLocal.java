package com.malex.lecture_7_Date.bestPractices;

import com.malex.lecture_7_Date.bestPractices.threadLocalDateFormat.ConcurrentDateFormatAccess;
import com.malex.utils.AbstractUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class UseThreadLocal extends AbstractUtils {

  private static final String DATE_FORMAT = "yyyy MM dd";

  @Test
  public void test() {
    LocalDate.now();
    LocalTime.now();
    LocalDateTime.now();
    Instant instant = Instant.now();
    Calendar instance = Calendar.getInstance();

    ConcurrentDateFormatAccess formatAccess = new ConcurrentDateFormatAccess(DATE_FORMAT);

    Date date = formatAccess.convertStringToDate("2018 12 23");
    println("date: " + date);

    date = formatAccess.convertStringToDate("2018 10 01");
    println("date: " + date);
  }
}
