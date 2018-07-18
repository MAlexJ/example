package com.malex.lecture_15_Thread.task_05_deadlock;

/**
 * Created by Alex on 25.02.2015.
 */
public class App_02_DeadloackTwo {

    public static void main(String[] args) {
        final Thread [] threads = new Thread[2];

        threads[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("#0 join #1");
                    threads[1].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threads[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("#1 join #0");
                    threads[0].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threads[0].start();

        threads[1].start();



    }


}
