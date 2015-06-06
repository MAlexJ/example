package example_07_bubbleSort;

public class Task_01_Array_Bubble {

    private static int[] array = {4, 77, 54, -7, 0, 32, 1, 5};

    public static void main(String[] args) {

        // 1. equals elem_0 with elem _1.
        // 2. go to next position, and replay equals elem.
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int result = array[i];
                array[i] = array[i + 1];
                array[i + 1] = result;
            }
        }

        System.out.println(java.util.Arrays.toString(array));

    }

}
