package com.malex.lecture_15_Thread.task_04_DemonThread;

/**
 * Created by Alex on 25.02.2015.
 */
public class App_02 {

    public static void main(String[] args) throws InterruptedException {

        //Create a new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Thread.sleep(100);
                        System.out.println("Demon");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //Set the value of parameter "true" for thread -> setDemon()
        thread.setDaemon(true);

        //To start a thread -> "thread"
        thread.start();

        //The thread "main" is waiting ->  sleep(500);
        Thread.sleep(500);
        System.out.println("========= Main ========");
    }

}
