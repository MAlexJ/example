package com.malex.lecture_4_array.example_10_inverter_array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tutorial: Guide to In-Place Sorting Algorithm Works with a Java Implementation
 * link: <a href="https://www.baeldung.com/java-in-place-sorting">In-Place Sorting Algorithm</a>
 */
public class InvertArrayInPlaceAlgorithm {

    @Test
    public void testSideEffects() {
        // test 1
        var array = new int[]{1, 2, 3, 4};
        invertArray(array);
        assertArrayEquals(new int[]{4, 3, 2, 1}, array);

        // test 2
        array = new int[]{1, 2, 3};
        invertArray(array);
        assertArrayEquals(new int[]{3, 2, 1}, array);

        // test 3
        array = new int[]{1, 2};
        invertArray(array);
        assertArrayEquals(new int[]{2, 1}, array);

        // test 4
        array = new int[]{1};
        invertArray(array);
        assertArrayEquals(new int[]{1}, array);
    }

    /**
     * Note: mutation of the input array !
     * <p>
     * The in-place algorithms are those that don’t need any auxiliary data structure in order to transform the input data.
     * Basically, it means that the algorithm doesn’t use extra space for input manipulation.
     * It practically overrides the input with the output
     * However, in reality, the algorithm actually may require a small and non-constant additional space for auxiliary variables.
     * The complexity of this space is in most cases O(log n), although sometimes anything less than linear is allowed.
     */
    private void invertArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[(length - 1) - i];
            array[(length - 1) - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

}
