package task_02_min_elem;

import java.util.Arrays;

public class FindMinElemArray_02 {

    public static void main(String[] args) {
        int[] numbers = {1, 6, 0, -59, -9};
        Arrays.sort(numbers);
        System.out.println("min elem -> "+numbers[0]);
    }

}
