package example_02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class GetNumberOdCurentDay {


	public static void main(String[] args) {


		String oldestDateString = "2015-10-01 15:00:00";
		String latestDateString = "2015-12-25 14:00:00";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime oldestDate = LocalDateTime.parse(oldestDateString, formatter);
		LocalDateTime latestDate = LocalDateTime.parse(latestDateString, formatter);

		int year = oldestDate.getYear();
		int month = oldestDate.getMonthValue();
		int day = oldestDate.getDayOfMonth();
		int hours = oldestDate.getHour();
		int minutes = oldestDate.getMinute();
		int seconds = oldestDate.getSecond();


		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println("hours:" + hours);


		// get the number of days in a month
		Calendar cal = Calendar.getInstance();
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("days: " + days);

		LocalDateTime now = LocalDateTime.now();

		System.out.println("now.getMonth(): " + now.getMonth());
		System.out.println("now.getMonthValue(): " + now.getMonthValue());
		System.out.println("now.getDayOfMonth(): " + now.getDayOfMonth());

	}

}
