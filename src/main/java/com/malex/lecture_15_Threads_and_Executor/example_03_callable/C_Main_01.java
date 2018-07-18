package com.malex.lecture_15_Threads_and_Executor.example_03_callable;

import java.util.concurrent.*;

public class C_Main_01
{
    public static void main(String[] args)
    {
        // #1: create
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(() ->
        {
            TimeUnit.SECONDS.sleep(2);
            return -1;
        });

        // #2: get
        System.out.println("future.isDone: " + future.isDone());
        try
        {
            Integer result = future.get(1, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (InterruptedException | TimeoutException | ExecutionException e)
        {
            e.printStackTrace();
        }

        // #3: finish
        finish(executor);
    }

    private static void finish(ExecutorService executor)
    {
        executor.shutdown();
        executor.shutdownNow();
    }
}
