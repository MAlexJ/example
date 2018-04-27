package com.malex.lecture_7_Date.example_04_Get_yesterday_date;

import java.util.Calendar;
import java.util.Date;

/**
 * Get yesterday's date.
 *
 * @author malex
 * @link http://stackoverflow.com/questions/11425236/get-yesterdays-date-using-date
 */
public class Main_Date_Get_Yesterday_Date {

    public static void main(String[] args) {
        getYesterday();
    }

    private static void getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println("Yesterday's date = " + cal.getTime());
    }

    private Date getMeYesterday() {
        return new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }

    private Date getPreviousWeekDate() {
        return new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000);
    }

    private Date getMeTomorrow() {
        return new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
    }

}
