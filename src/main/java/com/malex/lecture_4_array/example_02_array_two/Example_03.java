package com.malex.lecture_4_array.example_02_array_two;

public class Example_03 {

	public static void main(String[] args) {

		int[][] arrays = { { 10, 21 }, { 24, 27 } };
		for (int i = 0; i < arrays.length; i++) {
			System.out.println(arrays[i][i]);
		}

		System.out.println("arrays[0][0] -> " + arrays[0][0]);
		System.out.println("arrays[0][1] -> " + arrays[0][1]);
		System.out.println("arrays[1][0] -> " + arrays[1][0]);
		System.out.println("arrays[1][1] -> " + arrays[1][1]);
	}
}
