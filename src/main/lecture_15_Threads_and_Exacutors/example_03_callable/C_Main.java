package example_03_callable;

import java.util.concurrent.*;

public class C_Main
{
    public static void main(String[] args)
    {
        // #1: create callable
        Callable<Integer> task = () ->
        {
            TimeUnit.SECONDS.sleep(3);
            return 213;
        };

        // #2: create Executor
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("Future is done: " + future.isDone());
        Integer result = null;
        try
        {
            result = future.get();
        } catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        System.out.println("Future is done: " + future.isDone());
        System.out.println("result: " + result);

        // #3: finish
        finish(executor);
    }

    private static void finish(ExecutorService executor)
    {
        try
        {
            executor.shutdown();
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e)
        {
            System.err.println("Interrupted, message: " + e.getMessage());
        } finally
        {
            System.out.println("finish!");
            executor.shutdownNow();
        }
    }
}
