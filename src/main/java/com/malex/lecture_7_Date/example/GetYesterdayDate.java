package com.malex.lecture_7_Date.example;

import java.util.Calendar;
import java.util.Date;
import lombok.extern.java.Log;

/**
 * Get yesterday's date.
 *
 * @author malex
 * @link http://stackoverflow.com/questions/11425236/get-yesterdays-date-using-date
 */
@Log
public class GetYesterdayDate
{
    public static void main(String[] args)
    {
        getYesterday();
    }

    private static void getYesterday()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        log.info("Yesterday's date = " + cal.getTime());
    }

    private Date getMeYesterday()
    {
        return new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }

    private Date getPreviousWeekDate()
    {
        return new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000);
    }

    private Date getMeTomorrow()
    {
        return new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
    }

}
