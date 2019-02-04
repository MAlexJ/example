package com.malex.lecture_7_Date.example01;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.log4j.Log4j;

/**
 * Instant
 *
 * <p>Instant class is used to work with machine readable time format, it stores date time in unix
 * timestamp.
 */
@Log4j
public class InstantExample {

  public static void main(String[] args) {
    // Current timestamp
    Instant timestamp = Instant.now();
    log.debug("Current Timestamp = " + timestamp);

    // Instant from timestamp
    Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
    log.debug("Specific Time = " + specificTime);

    // Duration example
    Duration thirtyDay = Duration.ofDays(30);
    log.debug(thirtyDay);
  }
}
