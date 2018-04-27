package com.malex.lecture_7_Date.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        System.out.println("First date: " + date1);
        System.out.println("Second date: " + date2);

        long milliseconds = date2.getTime() - date1.getTime();
        System.out.println("\nРазница между датами в миллисекундах: " + milliseconds);

        // 1000 миллисекунд = 1 секунда
        int seconds = (int) (milliseconds / (1000));
        System.out.println("Разница между датами в секундах: " + seconds);

        // 60 000 миллисекунд = 60 секунд = 1 минута
        int minutes = (int) (milliseconds / (60 * 1000));
        System.out.println("Разница между датами в минутах: " + minutes);

        // 3 600 секунд = 60 минут = 1 час
        int hours = (int) (milliseconds / (60 * 60 * 1000));
        System.out.println("Разница между датами в часах: " + hours);

        // 24 часа = 1 440 минут = 1 день
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        System.out.println("Разница между датами в днях: " + days);

        //Note that in the listing, we obviously take less from the date of the most.
        // If on the contrary to take away from
        // the big date less the result we obtain the same result,
        // but with a minus sign.
    }

}
