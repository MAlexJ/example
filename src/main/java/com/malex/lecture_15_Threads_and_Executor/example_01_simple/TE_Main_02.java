package com.malex.lecture_15_Threads_and_Executor.example_01_simple;

import java.util.concurrent.TimeUnit;

public class TE_Main_02
{
    public static void main(String[] args)
    {
        String thread = Thread.currentThread().getName();
        Runnable runnable = () ->
        {
            try
            {
                System.out.println("Foo " + thread);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + thread);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        };

        new Thread(runnable).start();
    }
}
