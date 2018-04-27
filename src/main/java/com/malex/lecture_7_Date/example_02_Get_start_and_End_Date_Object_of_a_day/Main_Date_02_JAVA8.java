package com.malex.lecture_7_Date.example_02_Get_start_and_End_Date_Object_of_a_day;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Main_Date_02_JAVA8
{
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        Date currentDay = calendar.getTime();
        System.out.println("Current day: " + currentDay);

        Date startDay = getStartOfDay(currentDay);
        Date endDay = getEndOfDay(currentDay);

        System.out.println("Start day: " + startDay);
        System.out.println("End day: " + endDay);

    }

    private static Date getEndOfDay(Date date)
    {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalDateTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    private static Date getStartOfDay(Date date)
    {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfDay = localDateTime.with(LocalDateTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    private static Date localDateTimeToDate(LocalDateTime startOfDay)
    {
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());  //TODO ->>> java.lang.ArithmeticException: long overflow
    }

    private static LocalDateTime dateToLocalDateTime(Date date)
    {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }

}
