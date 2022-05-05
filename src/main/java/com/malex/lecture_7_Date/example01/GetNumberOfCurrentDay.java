package com.malex.lecture_7_Date.example01;

import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Log
public class GetNumberOfCurrentDay {

    public static void main(String[] args) {

        String oldestDateString = "2015-10-01 15:00:00";
        String latestDateString = "2015-12-25 14:00:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime oldestDate = LocalDateTime.parse(oldestDateString, formatter);
        LocalDateTime latestDate = LocalDateTime.parse(latestDateString, formatter);

        int year = oldestDate.getYear();
        int month = oldestDate.getMonthValue();
        int day = oldestDate.getDayOfMonth();
        int hours = oldestDate.getHour();
        int minutes = oldestDate.getMinute();
        int seconds = oldestDate.getSecond();

        log.info("year: " + year);
        log.info("month: " + month);
        log.info("day: " + day);
        log.info("hours:" + hours);

        // get the number of days in a month
        Calendar cal = Calendar.getInstance();
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        log.info("days: " + days);

        LocalDateTime now = LocalDateTime.now();

        log.info("now.getMonth(): " + now.getMonth());
        log.info("now.getMonthValue(): " + now.getMonthValue());
        log.info("now.getDayOfMonth(): " + now.getDayOfMonth());
    }
}
