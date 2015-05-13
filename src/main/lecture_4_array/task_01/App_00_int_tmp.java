package task_01;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class App_00_int_tmp {

    private static final Logger LOG = Logger.getLogger(App_00_int_tmp.class);

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};

        if (LOG.isDebugEnabled()) {
            LOG.debug(Arrays.toString(array));
        }


        for (int i = 0; i < array.length - 1; i++) {
            swap(array, i, i + 1);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug(Arrays.toString(array));
        }

    }

    public static void swap(int[] arr, int frs, int scd) {
        if (arr == null) {
            LOG.error("arr[] = null");
            return;
        }
        int tmp = arr[frs];
        arr[frs] = arr[scd];
        arr[scd] = tmp;

    }
}
