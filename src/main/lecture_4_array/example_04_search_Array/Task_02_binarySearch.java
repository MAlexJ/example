package example_04_search_Array;

import java.util.Arrays;

/**
 * Created by Alex on 05.06.2015.
 */
public class Task_02_binarySearch {

    public static void main(String[] args) {
        int[] array = {-8, 1, 2, 3, 6, 7, 8, 9};
        int x = 3;

        int binarySearch = Arrays.binarySearch(array, x);

        System.out.println("index of the search key -> " + binarySearch);


    }

}
