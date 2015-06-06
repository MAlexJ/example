package example_07_bubbleSort;

import java.util.Arrays;

public class Task_03_Array_BubbleSort_Full {

    private static int[] array = new int[]{89, 9, 6, 43, -9, -5, 0, 55, 60, 6, 6, 7, 4};

    public static void main(String[] args) {

        //revers array -> array.length - 1  to j > 1;
        for (int j = array.length - 1; j > 1; j--) {
            //array ->  i = 0 to i < j
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int result = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = result;
                }
            }

        }
        System.out.println(Arrays.toString(array));

    }


}
