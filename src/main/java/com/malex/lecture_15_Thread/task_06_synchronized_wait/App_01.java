package com.malex.lecture_15_Thread.task_06_synchronized_wait;

/**
 * Created by Alex on 02.03.2015.
 */
public class App_01 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                printText(2);
            }
        }).start();


    }

    public synchronized static void printText(int id) {
        while (true)
            System.out.println(id + " "+Thread.currentThread().getName());
    }

}
