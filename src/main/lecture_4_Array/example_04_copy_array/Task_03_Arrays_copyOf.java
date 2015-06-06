package example_04_copy_array;

import java.util.Arrays;

/**
 * Created by Alex on 05.06.2015.
 */
public class Task_03_Arrays_copyOf {

    public static void main(String[] args) {

        int[] array_1 = new int[]{2, 3, 4, 5, 67, 7};

        int[] array_2 = Arrays.copyOf(array_1, 6);

        System.out.println(Arrays.toString(array_2));

    }

}
