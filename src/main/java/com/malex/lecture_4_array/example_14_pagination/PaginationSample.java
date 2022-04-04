package com.malex.lecture_4_array.example_14_pagination;

import lombok.Setter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 0 1 2 3 4 5 6 7 8 9
 * 0 1 2 ... 9
 *   1 2 3  ... 9
 *     2 3 4  ... 9
 *       3 4 5  ... 9
 *         4 5 6  ... 9
 *           5 6 7  ... 9
 *             6 7 8  ... 9
 *               7 8 9
 */
@Setter
public class PaginationSample {

    private final int firstPosition = 0;
    private int lastPosition = 7;
    private int countElements;
    private int[] pagination;

    @Test
    public void testLimit() {
        // 1. total count of pagination
        setCountElements(3);
        // 2. init pagination button
        pagination = new int[countElements];
        for (int i = 0; i < pagination.length; i++) {
            pagination[i] = i;
        }

        // 1. limit
        assertArrayEquals(new int[]{0, 1, 2}, calculatePagination(0));
        assertArrayEquals(new int[]{0, 1, 2}, calculatePagination(1));
        assertArrayEquals(new int[]{5, 6, 7}, calculatePagination(7));

        // 2. sequence
        assertArrayEquals(new int[]{0, 1, 2}, calculatePagination(1));
        assertArrayEquals(new int[]{1, 2, 3}, calculatePagination(2));
        assertArrayEquals(new int[]{2, 3, 4}, calculatePagination(3));
        assertArrayEquals(new int[]{3, 4, 5}, calculatePagination(4));
        assertArrayEquals(new int[]{4, 5, 6}, calculatePagination(5));
        assertArrayEquals(new int[]{5, 6, 7}, calculatePagination(6));
        assertArrayEquals(new int[]{4, 5, 6}, calculatePagination(5));
        assertArrayEquals(new int[]{3, 4, 5}, calculatePagination(4));
        assertArrayEquals(new int[]{2, 3, 4}, calculatePagination(3));
        assertArrayEquals(new int[]{1, 2, 3}, calculatePagination(2));
        assertArrayEquals(new int[]{0, 1, 2}, calculatePagination(1));

        // 3. random
        assertArrayEquals(new int[]{0, 1, 2}, calculatePagination(1));
        assertArrayEquals(new int[]{0, 1, 2}, calculatePagination(0));
        assertArrayEquals(new int[]{1, 2, 3}, calculatePagination(2));
        assertArrayEquals(new int[]{2, 3, 4}, calculatePagination(3));
        assertArrayEquals(new int[]{1, 2, 3}, calculatePagination(2));
    }

    private int[] calculatePagination(int page) {
        int[] tempArr = new int[countElements];
        int temp = page;

        if (page == firstPosition) {
            for (int i = 0; i < countElements; i++) {
                tempArr[i] = temp++;
            }
            return tempArr;
        }

        if (page == lastPosition) {
            for (int i = countElements; i > 0; i--) {
                tempArr[i - 1] = temp--;
            }
            return tempArr;
        }

        if (page < pagination[pagination.length - 1]) {
            return pagination;
        }

        temp = page - 1;
        for (int i = 0; i < countElements; i++) {
            tempArr[i] = temp++;
        }

        return tempArr;
    }
}
