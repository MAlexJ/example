package com.malex.lecture_15_Concurrency.task_06_synchronized_wait;

/**
 * Created by Alex on 02.03.2015.
 */
public class App_03 {


    public static void main(String[] args) {
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                input(1);
            }
        });

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                input(2);
            }
        });

        thread_1.start();
        thread_2.start();
    }

    public synchronized static void input(int id) {

        System.out.println(id + " im here");

        try {
            Thread.sleep(700);
        } catch (InterruptedException ignore) { /*NOP*/ }
    }

}
