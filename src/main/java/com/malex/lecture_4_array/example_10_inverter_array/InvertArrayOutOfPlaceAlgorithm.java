package com.malex.lecture_4_array.example_10_inverter_array;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tutorial: Guide to In-Place Sorting Algorithm Works with a Java Implementation
 * link: <a href="https://www.baeldung.com/java-in-place-sorting">In-Place Sorting Algorithm</a>
 */
public class InvertArrayOutOfPlaceAlgorithm {

    @Test
    public void test() {
        var array = new int[]{1, 2, 3};
        assertArrayEquals(new int[]{3, 2, 1}, invertArray(array));

        array = new int[]{1, 2};
        assertArrayEquals(new int[]{2, 1}, invertArray(array));
    }

    /**
     * Out-of-Place Algorithm
     * On the other hand, we can also do this in a pretty simple, more obvious manner.
     * We can create a new array of the same size, copy the values from the original one in the corresponding order
     * and then delete the original array
     * Although this will do what we wanted it to do, it’s not efficient enough.
     * We have O(n) extra space required since we have two arrays to manipulate with.
     * Besides that, creating and removing a new array is usually a slow operation.
     */
    private int[] invertArray(int[] array) {
        int length = array.length;
        var result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = array[(length - 1) - i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

}
