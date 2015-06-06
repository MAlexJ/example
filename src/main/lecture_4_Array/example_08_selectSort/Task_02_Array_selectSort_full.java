package example_08_selectSort;

import java.util.Arrays;

public class Task_02_Array_selectSort_full {

    private static int[] array = new int[]{89, 9, 6, 43, -9, -5, 0, 55, 60, 6, 6, 7, 4};

    public static void main(String[] args) {


        int out, in, min;

        for (out = 0; out < array.length - 1; out++)    // outer loop
        {
            min = out;                                   // minimum
            for (in = out + 1; in < array.length; in++) // inner loop
                if (array[in] < array[min])             // if min greater,
                    min = in;                           // we have a new min

            int result = array[out];
            array[out] = array[min];
            array[min] = result;
        }  // end for(out)
        System.out.println(Arrays.toString(array));
    }
}
