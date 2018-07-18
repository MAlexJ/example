package com.malex.lecture_15_Threads_and_Executor.example_03_callable;

import java.util.ArrayList;
import java.util.List;

public class Test_Break_List
{
    private static long startTime = System.currentTimeMillis();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 0; i <= 5000000; i++)
        {
            list.add(i);
        }
//        newExecuteTask(list, 100);
        newExecuteTaskSingle(list);
    }

    private static void newExecuteTaskSingle(List<Integer> list) throws InterruptedException
    {
        new Thread(task(list)).start();
    }

    private static void newExecuteTask(List<Integer> list, int numberThread) throws InterruptedException
    {
        // #1: create -> ExecutorService
        List<Runnable> runnableList = new ArrayList<>();

        // #2: Filling -> callableList
        for (int start = 0; start < list.size(); start = start + numberThread)
        {
            System.out.println(start + " " + (start + numberThread));
            int end = start + numberThread >= list.size() ? list.size() : start + numberThread;
            runnableList.add(task(list.subList(start, end)));
        }

        // #3: create thread
        for (Runnable run : runnableList)
        {
            new Thread(run).start();
        }
    }

    private static Runnable task(List<Integer> list)
    {
        return () ->
        {
            list.forEach(item ->
            {
                System.out.println(item + " " + Thread.currentThread().getName());
                for (int i = 1; i <= Integer.MAX_VALUE - 2; i++)
                {
                    int x = i;
                }

            });
            System.out.println("   >>> End time: " + (System.currentTimeMillis() - startTime));
        };

    }
}
