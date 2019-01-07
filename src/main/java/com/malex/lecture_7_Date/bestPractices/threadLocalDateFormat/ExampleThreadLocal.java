package com.malex.lecture_7_Date.bestPractices.threadLocalDateFormat;

import java.util.Date;
import lombok.extern.log4j.Log4j;

@Log4j
public class ExampleThreadLocal {

  public static void main(String[] args) {
    ConcurrentDateFormatAccess formatAccess = new ConcurrentDateFormatAccess();

    Date date = formatAccess.convertStringToDate("2018 12 23");
    log.debug(date);

    date = formatAccess.convertStringToDate("2018 10 01");
    log.debug(date);
  }
}
