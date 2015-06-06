package example_10_Inverter_Array;

import org.apache.log4j.Logger;

import java.util.Arrays;


/**
 * Created by admin on 29.01.2015.
 */
public class ArrayInverter {
    private final static Logger LOG = Logger.getLogger(ArrayInverter.class);

    public static void main(String[] args) {
        LOG.debug("main");
        int[] array = {2, 1, 34, 21, 6, 7, 9};
        int[] array2 = {0, 1, 314, 21, 63, 7, 91};
        LOG.debug("array -> " + Arrays.toString(array));
        LOG.debug("array2 -> " + Arrays.toString(array2));


        //  nextTwo(int[] arr)
        nextTwo(array2);

        // OUT-Place algorithm
        int[] arrayOut = invertOut(array);
        LOG.debug("OUT-Place algorithm -> " + Arrays.toString(arrayOut));

        //In-place algorithm
        invertIn(array);
        LOG.debug("In-place algorithm -> " + Arrays.toString(array));


    }

    public static void nextTwo(int[] arr) {
        System.out.print("nextTwo(int[] arr) -> ");
        for (int i = 0; i < arr.length; i = i + 2) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // In-place algorithm
    public static void invertIn(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    // Out-place algorithm
    public static int[] invertOut(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[result.length - 1 - i] = arr[i];
        }
        return result;
    }

}
