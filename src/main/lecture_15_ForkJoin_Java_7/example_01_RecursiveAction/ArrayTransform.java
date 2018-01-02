package example_01_RecursiveAction;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

/**
 * This class illustrates how to create a ForkJoinTask that does not return a result.
 * RecursiveAction: a ForkJoinTask’s subclass for tasks that don’t return values.
 */
public class ArrayTransform extends RecursiveAction
{
    private static final int THRESHOLD = 1_000;

    private int[] array;
    private int number;

    private int start;
    private int end;

    private ArrayTransform(int[] array, int number, int start, int end)
    {
        this.array = array;
        this.number = number;
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args)
    {
        ForkJoinPool pool = new ForkJoinPool();

        System.out.printf("**************    BEFORE  ******************\n");
        System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
        System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
        System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
        System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
        System.out.printf("************** BEFORE  *****************\n");

        int[] arrInts = generateArrays(34, 45, 400);
        pool.invoke(new ArrayTransform(arrInts, 7, 0, arrInts.length));

        int[] arrIntsNew = generateArrays(9, 2000000, 140000000);
        pool.invoke(new ArrayTransform(arrIntsNew, 7, 0, arrIntsNew.length));

        System.out.printf("************** AFTER **************\n");
        System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
        System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
        System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
        System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
        System.out.printf("************** AFTER *****************\n");
    }

    private static int[] generateArrays(int randomNumberOrigin, int randomNumberBound, int limit)
    {
        IntStream intStream = new Random().ints(limit, randomNumberOrigin, randomNumberBound);
        return intStream.toArray();
    }

    @Override
    protected void compute()
    {
        if (end - start < THRESHOLD)
        {
            computeDirectly();
        } else
        {
            int middle = (end + start) / 2;

            ArrayTransform subTask1 = new ArrayTransform(array, number, start, middle);
            ArrayTransform subTask2 = new ArrayTransform(array, number, middle, end);

            invokeAll(subTask1, subTask2);
        }
    }

    private void computeDirectly()
    {
        System.out.println("Start: " + Thread.currentThread().getName());
        for (int i = start; i < end; i++)
        {
            array[i] = array[i] * number;
        }
        System.out.println("End: " + Thread.currentThread().getName());
    }
}
