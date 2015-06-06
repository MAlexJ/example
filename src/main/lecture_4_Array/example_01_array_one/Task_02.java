package example_01_array_one;

public class Task_02 {

	public static void main(String[] args) {

		int[] numArray = new int[5];
		
		numArray[0] = 1;
		numArray[1] = 2;
		numArray[2] = 3;
		numArray[3] = 4;
		numArray[4] = 5;

		// Array
		int numLength = numArray.length;

		System.out.println("numArray.length -> " + numLength);

		System.out.println(numArray);
	}

}
