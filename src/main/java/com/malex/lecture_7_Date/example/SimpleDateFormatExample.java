package com.malex.lecture_7_Date.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.extern.java.Log;

@Log
public class SimpleDateFormatExample {

  private static final String DATE_TEMPLATE = "yyyy/MM/dd HH:mm:ss";
  private static ThreadLocal<DateFormat> df =
      ThreadLocal.withInitial(() -> new SimpleDateFormat(DATE_TEMPLATE));

  public static void main(String[] args) {
    Date date = new Date();
    log.info("date: " +date);

    simpleDateFormatDate();
    simpleDateFormatCalendar();
  }

  private static void simpleDateFormatDate() {
    Date date = new Date();
    log.info("SimpleDateFormat with Date().class: " + df.get().format(date));
  }

  private static void simpleDateFormatCalendar() {
    Calendar cal = Calendar.getInstance();
    log.info("SimpleDateFormat with Calendar.getInstance(): " + df.get().format(cal.getTime()));
  }
}
