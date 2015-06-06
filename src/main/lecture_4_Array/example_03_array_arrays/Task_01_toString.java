package example_03_array_arrays;

import java.util.Arrays;

public class Task_01_toString {

	public static void main(String[] args) {

		int[] intArray = { 1, 25, 3, 0, 9 };

		System.out.println(Arrays.toString(intArray));

		Arrays.sort(intArray);

		System.out.println(Arrays.toString(intArray));

		System.out.println(Arrays.binarySearch(intArray, 0));

		int[] resltArray = Arrays.copyOf(intArray, 3);

		System.out.println(Arrays.toString(resltArray));

	}
}
