package example_03_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_Break_List
{
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args)
    {
        for (int i = 0; i <= 53; i++)
        {
            list.add(i);
        }
        newExecuteTask(list, 6);
    }

    private static void newExecuteTask(List<Integer> list, int numberThread)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(numberThread);
        for (int start = 0; start < list.size(); start = start + numberThread)
        {
            System.out.println(start + " " + (start + numberThread));
            int end = start + numberThread >= list.size() ? list.size() : start + numberThread;
            executorService.submit(task(list.subList(start, end)));
        }
        executorService.shutdown();
    }

    private static Runnable task(List<Integer> list)
    {
        return () ->
        {
            list.forEach(item ->
            {
                System.out.println(item + " " + Thread.currentThread().getName());
                for (int i = 0; i <= new Random().nextInt(Integer.MAX_VALUE); i++)
                {
                    int x = i;
                }
            });
        };
    }
}