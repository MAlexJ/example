package com.malex.lecture_4_array.example_04_copy_array;

import java.util.Arrays;

/**
 * Created by Alex on 05.06.2015.
 */
public class SimpleFor {

    public static void main(String[] args) {
        int[] array_1 = new int[]{2, 3, 4, 5, 67, 7};
        int[] array_2 = new int[6];

        // #1 before:
        System.out.println("Before :" + Arrays.toString(array_2));

        // #2 copy
        for (int i = 0; i < array_1.length; i++) {
            array_2[i] = array_1[i];
        }

        // #3 after:
        System.out.println("After: " + Arrays.toString(array_2));
    }
}
