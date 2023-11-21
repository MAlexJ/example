package com.malex.lecture_4_array.example_split_array_in_half;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SplitArraySample {

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(splitArrayInHalf(array), new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});

        array = new int[]{1, 2};
        assertArrayEquals(splitArrayInHalf(array), new int[][]{{1,}, {2}});

        array = new int[]{1};
        assertArrayEquals(splitArrayInHalf(array), new int[][]{{1}});

        array = new int[]{1, 2, 3};
        assertArrayEquals(splitArrayInHalf(array), new int[][]{{1, 2}, {3}});

        array = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(splitArrayInHalf(array), new int[][]{{1, 2, 3}, {4, 5}});
    }

    private int[][] splitArrayInHalf(int[] array) {
        int length = array.length;
        if (length == 1) {
            return new int[][]{{array[0]}};
        }

        int lengthOddNumber = length % 2;
        int[] left;
        int[] right;
        if (lengthOddNumber == 0) {
            int mid = length / 2;
            left = new int[mid];
            right = new int[length - mid];
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
                right[i] = array[mid + i];
            }
        } else {
            int middleOfArray = length / 2 + lengthOddNumber;
            left = new int[middleOfArray];
            right = new int[length - middleOfArray];
            for (int i = 0; i < middleOfArray; i++) {
                left[i] = array[i];
                if (i < length / 2) {
                    right[i] = array[middleOfArray + i];
                }
            }
        }
        var result = new int[][]{left, right};
        System.out.println(Arrays.deepToString(result));
        return result;
    }
}
