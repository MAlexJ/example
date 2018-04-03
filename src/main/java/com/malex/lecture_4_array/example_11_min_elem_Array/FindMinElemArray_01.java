package com.malex.lecture_4_array.example_11_min_elem_Array;

public class FindMinElemArray_01 {

    public static void main(String[] args) {
        int[] numbers = {1, 6, 0, -59,-9};
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i])
                min = numbers[i];
        }
        System.out.println(min);
    }
}
