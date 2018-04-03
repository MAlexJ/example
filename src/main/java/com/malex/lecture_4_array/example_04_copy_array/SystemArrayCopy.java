package com.malex.lecture_4_array.example_04_copy_array;

import java.util.Arrays;

/**
 * Created by Alex on 05.06.2015.
 */
public class SystemArrayCopy {

    public static void main(String[] args) {
        int[] array_1 = new int[]{2, 3, 4, 5, 67, 7};
        int[] array_2 = new int[6];

        // #1 before:
        System.out.println(Arrays.toString(array_2));

        // #2 cope -> native  arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
        System.arraycopy(array_1, 0, array_2, 0, 6);

        // #3 after
        System.out.println(Arrays.toString(array_2));
    }
}
