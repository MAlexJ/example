package com.malex.lecture_15_Concurrency.task_04_DemonThread;

/**
 * Created by Alex on 25.02.2015.
 */
public class App_04 {
    public static void main(String[] args) {
        //Exception -> IllegalThreadStateException
        Thread.currentThread().setDaemon(true);
        System.out.println(Thread.currentThread().getName() + " isDemon() " + Thread.currentThread().isDaemon());
    }

}
