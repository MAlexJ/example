package com.malex.lecture_25_Java_8.example_08_count_duplicated;

import java.util.*;

public class CountDuplicated {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("a");
		list.add("a");

		System.out.println("Example 1 - Count 'a' with frequency");
		System.out.println("a : " + Collections.frequency(list, "a"));

		System.out.println("\nExample 2 - Count all with frequency");

		Set<String> uniqueSet = new HashSet<>(list);
		for (String temp : uniqueSet) {
			System.out.println(temp + ": " + Collections.frequency(list, temp));
		}

	}

}
