package example_02_array_two;

import java.util.Arrays;

public  class Task_05 {
	//Field
	

	public static void main(String[] args) {
		int[] arrays = {  };
		
		// 1 var -> static
		print(arrays);
		
		// 2 var ->  Task_05 task_05 = new Task_05(); -> task_05.printNoStatic();
		Task_05 task_05 = new Task_05();
		task_05.printNoStatic(arrays);
		
		//System.out.println(Arrays.deepToString(arrays));

	}

	
	// 1 var -> static
	public static void print(int[] arrays) {
		// logic
		System.out.println(Arrays.toString(arrays));
		
	}

	// 2 var ->  Task_05 task_05 = new Task_05(); -> task_05.printNoStatic();
	public void printNoStatic(int[] arrays) {
		// logic
		
		System.out.println(Arrays.toString(arrays));
	}

}
