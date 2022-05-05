package com.malex.lecture_7_Date.example01;

import lombok.extern.java.Log;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Java 8 Date API Legacy Date Time Support
 *
 * <p>Legacy Date/Time classes are used in almost all the applications, so having backward
 * compatibility is a must. That’s why there are several utility methods through which we can
 * convert Legacy classes to new classes and vice versa.
 */
@Log
public class LegacyDateTimeSupport {

    public static void main(String[] args) {
        // Date to Instant
        Instant timestamp = new Date().toInstant();
        // Now we can convert Instant to LocalDateTime or other similar classes
        LocalDateTime date = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        log.info("Date = " + date);

        // Calendar to Instant
        Instant time = Calendar.getInstance().toInstant();
        log.info("Calendar.getInstance().toInstant(): " + time);
        // TimeZone to ZoneId
        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        log.info("TimeZone.getDefault().toZoneId(): " + defaultZone);

        // ZonedDateTime from specific Calendar
        ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
        log.info("new GregorianCalendar().toZonedDateTime(): " + gregorianCalendarDateTime);

        // Date API to Legacy classes
        Date dt = Date.from(Instant.now());
        log.info("Date.from(Instant.now()): " + dt);

        TimeZone tz = TimeZone.getTimeZone(defaultZone);
        log.info("TimeZone.getTimeZone(defaultZone): " + tz);

        GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
        log.info("GregorianCalendar.from(gregorianCalendarDateTime): " + gc);
    }
}
