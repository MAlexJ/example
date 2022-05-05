package com.malex.lecture_7_Date.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.java.Log;

/**
 * Find the difference between dates
 * <p>
 * Date of conversion from milliseconds to seconds / minutes / hours / days:
 * <p>
 * 1000 milliseconds = 1 second
 * 60,000 milliseconds = 60 seconds = 1 minute
 * 3600 seconds = 60 minutes = 1 hour
 * 24 hours = 1440 minutes = 1 day
 */
@Log
public class FindDifferenceBetweenDates
{
    public static void main(String[] args)
    {
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date1 = dateFormat.parse("15.05.2018");
            Date date2 = dateFormat.parse("17.05.2018");

            findDifferenceDates(date1, date2);

        } catch (ParseException e)
        {
            throw new IllegalArgumentException("Incorrect date!");
        }
    }

    /**
     * Find the difference between dates.
     *
     * @param date1 first date.
     * @param date2 second date.
     */
    private static void findDifferenceDates(Date date1, Date date2)
    {
        log.info("First date: " + date1);
        log.info("Second date: " + date2);

        long milliseconds = date2.getTime() - date1.getTime();
        log.info("\nThe difference between the dates in milliseconds: " + milliseconds);

        // 1000 milliseconds = 1 second
        int seconds = (int) (milliseconds / (1000));
        log.info("The difference between the dates in seconds: " + seconds);

        // 60,000 milliseconds = 60 seconds = 1 minute
        int minutes = (int) (milliseconds / (60 * 1000));
        log.info("The difference between the dates in minutes: " + minutes);

        // 3 600 seconds = 60 minutes = 1 hour
        int hours = (int) (milliseconds / (60 * 60 * 1000));
        log.info("Difference between dates in hours: " + hours);

        // 24 hours = 1 440 minutes = 1 day
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        log.info("Difference between dates in days: " + days);

        //Note that in the listing, we obviously take less from the date of the most.
        // If on the contrary to take away from
        // the big date less the result we obtain the same result,
        // but with a minus sign.
    }
}
