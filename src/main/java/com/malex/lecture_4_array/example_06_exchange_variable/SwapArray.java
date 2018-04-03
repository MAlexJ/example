package com.malex.lecture_4_array.example_06_exchange_variable;

import java.util.Arrays;

public class SwapArray {

    public static int[] array = new int[2];

    public static void main(String[] args) {
        array[0] = 34;
        array[1] = 56;
        System.out.println(Arrays.toString(array));

        swap(array);
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array) {
        int result = array[0];
        array[0] = array[1];
        array[1] = result;
    }
}
