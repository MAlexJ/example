package com.malex.lecture_7_Date.java_util.timezone;

import com.malex.utils.AbstractUtils;
import java.util.TimeZone;
import org.junit.Test;

public class TimeZone_class extends AbstractUtils {

  @Test
  public void initialization() {
    TimeZone aDefault = TimeZone.getDefault();
    println("Default TimeZone: ", aDefault);

    TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
    println("TimeZone: ", timeZone);

    timeZone = TimeZone.getTimeZone(TimeZone.getAvailableIDs()[1]);
    println("TimeZone: ", timeZone);
    
    timeZone = TimeZone.getTimeZone("UTC");
    println("TimeZone: ", timeZone);
  }
}
