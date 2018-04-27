package com.malex.lecture_7_Date.example_06;

import java.time.Duration;
import java.time.Instant;

public class Main_Date_06
{
    public static void main(String[] args)
    {
        // start
        Instant start = Instant.ofEpochMilli(1501167341508L);
        // end
        Instant end = Instant.now();

        Duration dur = Duration.between(start, end);
        long minutes = dur.toMinutes();

        System.out.println(" minutes: " + minutes);
    }
}