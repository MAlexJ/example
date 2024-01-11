package com.malex.lecture_29_algorithm.impl;

import com.malex.lecture_29_algorithm.ISort;
import java.util.Arrays;
import lombok.extern.java.Log;

@Log
public class SortSelection implements ISort {

    static class AppRunner {
        public static void main(String[] args) {
            var algorithm = new SortSelection();
            int[] array = algorithm.selectionSort(new int[]{10, -3, 4, 8, -1, 0, 11});
            log.info(Arrays.toString(array));
        }
    }


    /**
     * Swap array elements
     *
     * @param array      - array
     * @param startIndex - start position
     * @param endIndex   - end position
     */
    @Override
    public void swapElement(int[] array, int startIndex, int endIndex) {
        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;
    }

    /**
     * @param array      - init array
     * @param startIndex - starting position for search
     * @return the smallest element of array
     */
    @Override
    public int indexLowest(int[] array, int startIndex) {
        int desiredIndex = startIndex;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < array[desiredIndex]) {
                desiredIndex = i;
            }
        }
        return desiredIndex;
    }

    /**
     * Sort array
     *
     * @param array to sort
     * @return sorted array
     */
    @Override
    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfSmallestElement = indexLowest(array, i);
            swapElement(array, indexOfSmallestElement, i);
        }
        return array;
    }
}
