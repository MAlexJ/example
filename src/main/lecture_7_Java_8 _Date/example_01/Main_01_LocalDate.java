package example_01;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * LocalDate
 * <p>
 * LocalDate is an immutable class that represents Date with default format of yyyy-MM-dd.
 * We can use now() method to get the current date.
 * We can also provide input arguments for year, month and date to create LocalDate instance.
 * This class provides overloaded method for now() where we can pass ZoneId for getting date in specific time zone.
 * This class provides the same functionality as java.sql.Date. Let’s look at a simple example for it’s usage.
 */
public class Main_01_LocalDate {

    public static void main(String[] args) {
        //Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date= " + today);

        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date= "+firstDay_2014);

        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid date 'February 29' as '2014' is not a leap year

        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST= "+todayKolkata);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= "+dateFromBase);

        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014= "+hundredDay2014);

    }
}
