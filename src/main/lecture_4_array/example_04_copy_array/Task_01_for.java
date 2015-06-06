package example_04_copy_array;

import java.util.Arrays;

/**
 * Created by Alex on 05.06.2015.
 */
public class Task_01_for {

    public static void main(String[] args) {
        int[] array_1 = new int[]{2, 3, 4, 5, 67, 7};
        int[] array_2 = new int[6];

        System.out.println(Arrays.toString(array_2));

        for (int i = 0; i < array_1.length; i++) {
            array_2[i] = array_1[i];
        }

        System.out.println(Arrays.toString(array_2));
    }
}
