package example_02_array_two;

import java.util.Arrays;

public class Task_04 {

	public static void main(String[] args) {
		
		int[][] arrays = new int[2][3];
		
		int  k = 0;
		
		//Заполнение массива
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				arrays[i][j]=k;
				k++;
			}
		}
		
		//(0.0)=0  (0.1)=1  (0.2)=2
		//(1.0)=3  (1.1)=4  (1.2)=5
		
		System.out.println(arrays[0][1]);
		System.out.println(arrays[1][2]);
		
		System.out.println(Arrays.deepToString(arrays));
		
	}
}
