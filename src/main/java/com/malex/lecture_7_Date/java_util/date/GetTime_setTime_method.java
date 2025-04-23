package com.malex.lecture_7_Date.java_util.date;

import java.util.Date;
import org.junit.Test;

public class GetTime_setTime_method extends Date_class {

  @Test
  public void test() {
    Date now = new Date();

    /*
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
     */
    long time = now.getTime();
    println("time: ", time);

    /*
     * Sets this Date object to represent a point in time that is time milliseconds after January 1, 1970 00:00:00 GMT.
     */
    now.setTime(1745408085834L);
    println("now: ", now);
  }
}
