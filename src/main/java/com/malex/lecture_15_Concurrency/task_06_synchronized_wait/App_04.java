package com.malex.lecture_15_Concurrency.task_06_synchronized_wait;

/**
 * Created by Alex on 02.03.2015.
 */
public class App_04 {

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

    public static void input(int id) {

        System.out.println(id + " im here, A");
        synchronized (App_04.class) {
            System.out.println(id + " im here, B");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) { /*NOP*/ }
        }
    }
}
