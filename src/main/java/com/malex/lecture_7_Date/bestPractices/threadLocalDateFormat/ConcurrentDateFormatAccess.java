package com.malex.lecture_7_Date.bestPractices.threadLocalDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentDateFormatAccess {

  private final ThreadLocal<DateFormat> threadLocal;

  public ConcurrentDateFormatAccess(String dateFormat) {
    // Creates a thread local variable.
    // The initial value of the variable is determined by invoking the get method on the Supplier.
    threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat(dateFormat));
  }

  public Date convertStringToDate(String dateString) {
    try {
      return getDateFormat().parse(dateString);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Incorrect the value " + dateString + " of date");
    }
  }

  /**
   * Returns the value in the current thread's copy of this thread-local variable. If the variable
   * has no value for the current thread, it is first initialized to the value returned by an
   * invocation of the initialValue method.
   */
  private DateFormat getDateFormat() {
    return threadLocal.get();
  }
}
