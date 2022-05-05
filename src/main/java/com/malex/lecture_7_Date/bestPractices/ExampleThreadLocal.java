package com.malex.lecture_7_Date.bestPractices;

import com.malex.lecture_7_Date.bestPractices.threadLocalDateFormat.ConcurrentDateFormatAccess;
import lombok.extern.java.Log;

import java.util.Date;

@Log
public class ExampleThreadLocal {

    public static void main(String[] args) {
        ConcurrentDateFormatAccess formatAccess = new ConcurrentDateFormatAccess();

        Date date = formatAccess.convertStringToDate("2018 12 23");
        log.info("date: " + date);

        date = formatAccess.convertStringToDate("2018 10 01");
        log.info("date: " + date);
    }
}
