package com.malex.lecture_4_array.example_07_bubbleSort;

import java.util.Arrays;


public class Task_02_Array_BubbleSort_Begin {
    private static int[] array = new int[]{89, 9, 6, 43, -9, -5, 0, 55, 60, 6, 6, 7, 4};

    public static void main(String[] args) {
        //for 0 to length-1
        //for(int j = 0; j < array.length - 1; j++) {

        //reverse to array[2], exclude: [1], [0]
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < array.length - 1; i++) {
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
