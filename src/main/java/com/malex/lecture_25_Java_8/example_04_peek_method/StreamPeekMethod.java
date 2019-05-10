package com.malex.lecture_25_Java_8.example_04_peek_method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * peek() method :- The main purpose of this method is to support debugging.
 * <p>
 * http://codedestine.com/java-8-stream-peek-method/
 */
public class StreamPeekMethod {

	public static void main(String[] args) {

		List<Integer> numList = Arrays.asList(1, 3, 4, 5, 2, 7, 9);

		implementationInJava7(numList);

		implementationInJava8(numList);

	}

	private static void implementationInJava8(List<Integer> numList) {
		List<Integer> filterList = numList
				  .stream()
				  .filter(e -> e >= 5)
				  .peek(e -> System.out.println("Filtered #1 value: " + e))
				  .filter(e -> e < 9)
				  .peek(e -> System.out.println(" > Filtered #2 value: " + e))
				  .collect(Collectors.toList());
		System.out.println(filterList);
	}

	private static void implementationInJava7(List<Integer> numList) {
		List<Integer> filterList = new ArrayList<>();

		for (Integer num : numList) {
			if (num >= 5) {
				filterList.add(num);
				System.out.println("Filtered Value : " + num);
			}
		}

		List<Integer> finalList = new ArrayList<>();
		for (Integer num : filterList) {
			if (num < 9) {
				finalList.add(num);
			}
		}

		System.out.println(finalList + "\n");
	}

}