package com.malex.lecture_15_Concurrency.task_07_synch_sleep_wait;

/**
 * Created by Alex on 3/3/2015.
 */
public class App_01 {

    public static void main(String[] args) {

        for (int k = 0; k < 5; k++) {
            final int tmp = k;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    print(tmp);
                }
            }).start();
        }
    }

    public synchronized static void print(int id) {
        System.out.println(id+" * - wait - sleep ");
        try {
            App_01.class.wait(2000);
        } catch (InterruptedException ignore) {
            /*NOP*/
        }
        System.out.println(id+" wait - * - sleep ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            /*NOP*/
        }
        System.out.println(id+" wait - sleep - * ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            /*NOP*/
        }
    }

}
