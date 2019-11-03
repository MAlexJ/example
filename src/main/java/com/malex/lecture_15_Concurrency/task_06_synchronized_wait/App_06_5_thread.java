package com.malex.lecture_15_Concurrency.task_06_synchronized_wait;

/**
 * Created by Alex on 02.03.2015.
 */
public class App_06_5_thread {


    public static void main(String[] args) {

        for(int i =0; i<5;i++){
            final int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    input(tmp);
                }
            }).start();

        }

    }


    public synchronized static void input(int id) {
        System.out.println(id+" im here");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignore) {
            /*NOP*/
        }
    }
}
