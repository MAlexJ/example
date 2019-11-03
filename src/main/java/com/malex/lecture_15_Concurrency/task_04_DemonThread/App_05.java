package com.malex.lecture_15_Concurrency.task_04_DemonThread;

/**
 * Created by Alex on 25.02.2015.
 */
public class App_05 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i =0; i<5;i++){
                    System.out.println("To start thread -> " + Thread.currentThread().getName());
                }

                    //Start new thread -> "threadInner"
                    Thread threadInner = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            for (; ; ) {
                                try {
                                    System.out.println("To start thread -> " + Thread.currentThread().getName());
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });

                //Start thread -> "threadInner"
                threadInner.start();

            }
        });

        System.out.println("To start thread -> " + Thread.currentThread().getName());

        //Set the value of parameter "true" for "thread" -> setDemon()
        thread.setDaemon(true);
        // Start thread -> "thread"
        thread.start();

        Thread.sleep(500);
        System.out.println("The end thread -> " + Thread.currentThread().getName() + "********************************************");


    }
}
