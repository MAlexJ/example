package com.malex.lecture_7_Date.example_02_Get_start_and_End_Date_Object_of_a_day;

import java.util.Calendar;
import java.util.Date;

public class Main_Date_02_JAVA7
{

    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        Date currentDay = calendar.getTime();
        System.out.println("Current Date: " + currentDay);

        Date startDay = getStartOfDay(currentDay);
        Date endDay = getEndOfDay(currentDay);

        System.out.println("Start day: " + startDay);
        System.out.println("End day: " + endDay);
    }

    /**
     * The following function is to get Start Time Date Object of a day:
     * <p>
     * Input    : Tuesday May 13, 2014 12:45:45
     * Output : Tuesday May 13, 2014 00:00:00
     *
     * @param date current date
     * @return start date of day
     */
    private static Date getStartOfDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * The following function is to get End Time Date Object of a day:
     * <p>
     * Input    : Tuesday May 13, 2014 12:45:45
     * Output : Tuesday May 13, 2014 23:59:59
     *
     * @param date current day
     * @return end date of day
     */
    private static Date getEndOfDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
}
