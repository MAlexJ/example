package com.malex.lecture_4_array.example_14_pagination;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/**
 * 0 1 2 3 4 5 6 7 8 9
 * 0 1 2 ... 9
 * 1 2 3  ... 9
 * 2 3 4  ... 9
 * 3 4 5  ... 9
 * 4 5 6  ... 9
 * 5 6 7  ... 9
 * 6 7 8  ... 9
 * 7 8 9
 */
public class PaginationSample {

    private static class Pagination {
        private final int firstPosition = 0;

        /**
         * Total number of pages
         */
        private final int totalPages;

        /**
         * Number of elements per page
         */
        private final int elementsPerPage;

        /**
         * display result of pagination
         */
        private final int[] resultOfPagination;

        public Pagination(int elementsPerPage, int totalPages) {
            this.totalPages = totalPages;
            this.elementsPerPage = elementsPerPage;
            this.resultOfPagination = IntStream.range(firstPosition, elementsPerPage).toArray();
        }

        protected int[] calculatePagination(int page) {
            int[] tempArr = new int[elementsPerPage];
            int temp = page;

            if (page == firstPosition) {
                for (int i = 0; i < elementsPerPage; i++) {
                    tempArr[i] = temp++;
                }
                return tempArr;
            }

            if (page == totalPages) {
                for (int i = elementsPerPage; i > 0; i--) {
                    tempArr[i - 1] = temp--;
                }
                return tempArr;
            }

            if (page < resultOfPagination[resultOfPagination.length - 1]) {
                return resultOfPagination;
            }

            temp = page - 1;
            for (int i = 0; i < elementsPerPage; i++) {
                tempArr[i] = temp++;
            }

            return tempArr;
        }
    }

    @Test
    public void testLimit() {
        var pagination = new Pagination(3, 7);

        // 1. limit
        assertArrayEquals(new int[]{0, 1, 2}, pagination.calculatePagination(0));
        assertArrayEquals(new int[]{0, 1, 2}, pagination.calculatePagination(1));
        assertArrayEquals(new int[]{5, 6, 7}, pagination.calculatePagination(6));
        assertArrayEquals(new int[]{5, 6, 7}, pagination.calculatePagination(7));

        // 2. sequence
        assertArrayEquals(new int[]{0, 1, 2}, pagination.calculatePagination(1));
        assertArrayEquals(new int[]{1, 2, 3}, pagination.calculatePagination(2));
        assertArrayEquals(new int[]{2, 3, 4}, pagination.calculatePagination(3));
        assertArrayEquals(new int[]{3, 4, 5}, pagination.calculatePagination(4));
        assertArrayEquals(new int[]{4, 5, 6}, pagination.calculatePagination(5));
        assertArrayEquals(new int[]{5, 6, 7}, pagination.calculatePagination(6));
        assertArrayEquals(new int[]{4, 5, 6}, pagination.calculatePagination(5));
        assertArrayEquals(new int[]{3, 4, 5}, pagination.calculatePagination(4));
        assertArrayEquals(new int[]{2, 3, 4}, pagination.calculatePagination(3));
        assertArrayEquals(new int[]{1, 2, 3}, pagination.calculatePagination(2));
        assertArrayEquals(new int[]{0, 1, 2}, pagination.calculatePagination(1));

        // 3. random
        pagination = new Pagination(4, 10);
        assertArrayEquals(new int[]{0, 1, 2, 3}, pagination.calculatePagination(1));
        assertArrayEquals(new int[]{0, 1, 2, 3}, pagination.calculatePagination(0));
        assertArrayEquals(new int[]{0, 1, 2, 3}, pagination.calculatePagination(2));
        assertArrayEquals(new int[]{2, 3, 4, 5}, pagination.calculatePagination(3));
    }
}
