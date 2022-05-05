package com.malex.lecture_7_Date.example;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.java.Log;

@Log
public class DurationBetweenStartAndEndDate {

  public static void main(String[] args) {
    // Instant start
    Instant start = Instant.ofEpochMilli(1501167341508L);
    // Instant end
    Instant end = Instant.now();

    Duration dur = Duration.between(start, end);
    long minutes = dur.toMinutes();

    log.info(" minutes: " + minutes);
  }
}
