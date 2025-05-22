package com.malex.lecture_7_Date.java_sql.timestamp;

import com.malex.utils.AbstractUtils;
import java.sql.Timestamp;
import org.junit.Test;

/*
 * TIMESTAMP
 *
 * The range is '1970-01-01 00:00:01.000000' UTC to '2038-01-19 03:14:07.499999' UTC.
 * TIMESTAMP values are stored as the number of seconds since the epoch ('1970-01-01 00:00:00' UTC).
 * A TIMESTAMP cannot represent the value '1970-01-01 00:00:00' because that is equivalent to 0 seconds from the epoch
 * and the value 0 is reserved for representing '0000-00-00 00:00:00', the “zero” TIMESTAMP value.
 *
 * DATETIME[(fsp)]
 *
 * A date and time combination.
 * The supported range is '1000-01-01 00:00:00.000000' to '9999-12-31 23:59:59.499999'.
 * MySQL displays DATETIME values in 'YYYY-MM-DD hh:mm:ss[.fraction]' format,
 * but permits assignment of values to DATETIME columns using either strings or numbers.
 *
 * The main differences between DATETIME and TIMESTAMP in SQL are related to time zone handling
 * and their storage characteristics:
 *
 * 1. Time Zone Handling:
 *
 *   - DATETIME:
 *       It does not consider time zone.
 *       It stores the date and time as they are, without any conversion based on the server’s time zone
 *       or any specific time zone.
 *
 *   - TIMESTAMP:
 *       It is time zone-aware.
 *       The TIMESTAMP value is stored as UTC and converted to the local time zone
 *       when retrieved based on the time zone setting of the database server or the client.
 */
public class Timestamp_class extends AbstractUtils {

  @Test
  public void createFromMilliseconds() {
    long millis = System.currentTimeMillis();
    Timestamp ts = new Timestamp(millis);
    println("ts: ", ts);
  }

  @Test
  public void createFromString() {
    Timestamp ts = Timestamp.valueOf("2025-04-30 15:45:30");
    println("ts: ", ts);
  }
}
