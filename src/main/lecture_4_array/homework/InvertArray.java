package homework;

import java.util.Arrays;

import example_01_array_one.Task_01;



public class InvertArray {

	

	// method
	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int[] array2 = { 10, 11, 12, 12, 13, 14, 15 };

		// In-place algorithm
		invertIn(array);
		System.out.println(Arrays.toString(array));

		// Out-place algorithm
		System.out.println(Arrays.toString(invertOut(array2)));
		//while(true){}

	}

	// In-place algorithm
	public static void invertIn(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = tmp;
		}
	}

	// Out-place algorithm
	public static int[] invertOut(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[result.length - 1 - i] = arr[i];
		}
		return result;
	}
	
	//********************************************************
	
	public static int[] invertOut1(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[result.length - 1 - i] = arr[i];
		}
		return result;
	}
	
	public static int[] invertOut2(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[result.length - 1 - i] = arr[i];
		}
		return result;
	}
	

}
