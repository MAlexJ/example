package com.malex.lecture_4_array.example_04_copy_array;

import java.util.Arrays;

/**
 * Created by Alex on 05.06.2015.
 */
public class ArraysCopyOf {

    public static void main(String[] args) {
        int[] array_1 = new int[]{2, 3, 4, 5, 67, 7};

        // #1 before
        int[] array_2 = Arrays.copyOf(array_1, 6);

        // #2 after
        System.out.println(Arrays.toString(array_2));
    }
}
