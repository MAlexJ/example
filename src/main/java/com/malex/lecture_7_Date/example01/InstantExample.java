package com.malex.lecture_7_Date.example01;

import lombok.extern.java.Log;

import java.time.Duration;
import java.time.Instant;

/**
 * Instant
 *
 * <p>Instant class is used to work with machine readable time format, it stores date time in unix
 * timestamp.
 */
@Log
public class InstantExample {

    public static void main(String[] args) {
        // Current timestamp
        Instant timestamp = Instant.now();
        log.info("Current Timestamp = " + timestamp);

        // Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        log.info("Specific Time = " + specificTime);

        // Duration example
        Duration thirtyDay = Duration.ofDays(30);
        log.info("Duration: " + thirtyDay);
    }
}
