package com.malex.lecture_4_array.example_03_array_arrays;

import java.util.Arrays;

public class PrintArraytoString {

	public static void main(String[] args) {

		int[] intArray = { 1, 25, 3, 0, 9 };
		System.out.println(Arrays.toString(intArray));

		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));

		System.out.println(Arrays.binarySearch(intArray, 0));

		int[] resultArray = Arrays.copyOf(intArray, 3);
		System.out.println(Arrays.toString(resultArray));
	}
}
