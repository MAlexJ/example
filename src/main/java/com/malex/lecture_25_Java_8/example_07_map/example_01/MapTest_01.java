package com.malex.lecture_25_Java_8.example_07_map.example_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest_01 {

	public static void main(String[] args) {

		List<String> list = Stream.of("05/01/2017",
				  "06/01/2017", "07/01/2017",
				  "08/01/2017", "09/01/2017",
				  "10/01/2017", "11/01/2017")
				  .collect(Collectors.toList());

		String collect = list
				  .stream()
				  .collect(Collectors.joining(","));
		System.out.println("Split: " + collect);

		List<Date> dates = list.stream()
				  .map(DateFunction::formatStringToDate)
				  .collect(Collectors.toList());
		dates.forEach(System.out::println);

		System.out.println("Weekend: ");

		dates.stream()
				  .filter(WeekendPredicate::isWeekend)
				  .forEach(System.out::println);
	}

}

interface DateFunction {

	/**
	 * Function -> String to date
	 */
	static Date formatStringToDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyy");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

interface WeekendPredicate {

	/**
	 * Check day -> SUNDAY or SATURDAY
	 */
	static boolean isWeekend(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int nDay = calendar.get(Calendar.DAY_OF_WEEK);

		return nDay == Calendar.SUNDAY
				  || nDay == Calendar.SATURDAY;
	}
}