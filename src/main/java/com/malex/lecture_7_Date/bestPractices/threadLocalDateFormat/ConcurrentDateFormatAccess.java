package com.malex.lecture_7_Date.bestPractices.threadLocalDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ConcurrentDateFormatAccess {

  private static final String DATE_TEMPLATE = "yyyy MM dd";

  private ThreadLocal<DateFormat> df =
      ThreadLocal.withInitial(() -> new SimpleDateFormat(DATE_TEMPLATE));

  Date convertStringToDate(String dateString) {
    try {
      return df.get().parse(dateString);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Incorrect the value " + dateString + " of date");
    }
  }
}
