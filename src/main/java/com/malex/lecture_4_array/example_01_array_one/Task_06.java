package com.malex.lecture_4_array.example_01_array_one;

public class Task_06 {

	public static void main(String[] args) {
		int[] number = { 2, 5, 7, 6 };
		iterReq(number, 0);
	}

	private static void iterReq(int[] array, int i) {
		System.out.println(array[i]);
		i++;
		if (i < array.length) {
			iterReq(array, i);
		}
	}
}
