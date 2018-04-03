package com.malex.lecture_4_array.example_05_search_Array;

/**
 * Created by Alex on 05.06.2015.
 */
public class SimpleForeach {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 7, 8, 9};
        int x = 3;

        for (int item : array) {
            if (item == x) {
                System.out.println(x);
            }
        }
    }
}
