package com.malex.lecture_7_Date.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by malex on 09.08.16.
 */
public class SimpleDateFormatExample
{
    private final static DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.println(date);

        simpleDateFormat_Date();
        simpleDateFormat_Calendar();
    }

    private static void simpleDateFormat_Date()
    {
        Date date = new Date();
        System.out.println("SimpleDateFormat with Date().class: " + SIMPLE_DATE_FORMAT.format(date));
    }

    private static void simpleDateFormat_Calendar()
    {
        Calendar cal = Calendar.getInstance();
        System.out.println("SimpleDateFormat with Calendar.getInstance(): " + SIMPLE_DATE_FORMAT.format(cal.getTime()));
    }
}
