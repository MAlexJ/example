package example_01_array_one;

public class Task_06 {

	public static void main(String[] args) {
		int[] number = { 2, 5, 7, 6 };
		iterR(number, 0);
	}

	public static void iterR(int[] array, int i) {
		System.out.println(array[i]);
		i++;
		if (i < array.length) {
			iterR(array, i);
		}

	}

}
