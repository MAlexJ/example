package example_03_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author malex
 */
public class Time_Main {

    public static void main(String[] args) throws ParseException {

        long time_01 = setDate("09:00 AM");
        System.out.println("Time millis: " + time_01);


        long time_02 = setDate("10:00 PM");
        System.out.println("Time millis: " + time_02);



        System.out.println(new Date(time_02));

    }

    // format:  09:00 AM
    private static long setDate(String date) throws ParseException {

        Date dateIn = new SimpleDateFormat("hh:mm a").parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateIn);
        Date time = cal.getTime();

        System.out.println("Time: " + new SimpleDateFormat("hh:mm a").format(dateIn));

        return time.getTime();
    }


}
