package com.malex.lecture_7_Date.example_01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by malex on 09.08.16.
 */
public class SimpleDateFormatExample
{
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        simpleDateFormat_Date();
        simpleDateFormat_Calendar();
    }

    private static void simpleDateFormat_Date() {
        DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("SimpleDateFormat + date: " + dateFormat.format(date));
    }

    private static void simpleDateFormat_Calendar() {
        DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println("SimpleDateFormat + Calendar" + dateFormat.format(cal.getTime()));
    }
}
