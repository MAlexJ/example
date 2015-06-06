package example_09_insertSort;

import java.util.Arrays;

public class Task_01_Array_insertSort_full {

    private static int[] array = new int[]{89, 9, 6, 43, -9, -5, 0, 55, 60, 6, 6, 7, 4};

    public static void main(String[] args) {

        int in, out;

        for (out = 1; out < array.length; out++)     // out is dividing line
        {
            int temp = array[out];                    // remove marked item
            in = out;                                 // start shifts at out
            while (in > 0 && array[in - 1] >= temp)   // until one is smaller,
            {
                array[in] = array[in - 1];            // shift item to right
                --in;                                 // go left one position
            }
            array[in] = temp;                          // insert marked item
        }

        System.out.println(Arrays.toString(array));
    }
}
