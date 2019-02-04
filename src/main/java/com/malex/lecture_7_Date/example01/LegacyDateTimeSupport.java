package com.malex.lecture_7_Date.example01;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import lombok.extern.log4j.Log4j;

/**
 * Java 8 Date API Legacy Date Time Support
 *
 * <p>Legacy Date/Time classes are used in almost all the applications, so having backward
 * compatibility is a must. That’s why there are several utility methods through which we can
 * convert Legacy classes to new classes and vice versa.
 */
@Log4j
public class LegacyDateTimeSupport {

  public static void main(String[] args) {
    // Date to Instant
    Instant timestamp = new Date().toInstant();
    // Now we can convert Instant to LocalDateTime or other similar classes
    LocalDateTime date = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
    log.debug("Date = " + date);

    // Calendar to Instant
    Instant time = Calendar.getInstance().toInstant();
    log.debug(time);
    // TimeZone to ZoneId
    ZoneId defaultZone = TimeZone.getDefault().toZoneId();
    log.debug(defaultZone);

    // ZonedDateTime from specific Calendar
    ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
    log.debug(gregorianCalendarDateTime);

    // Date API to Legacy classes
    Date dt = Date.from(Instant.now());
    log.debug(dt);

    TimeZone tz = TimeZone.getTimeZone(defaultZone);
    log.debug(tz);

    GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
    log.debug(gc);
  }
}
