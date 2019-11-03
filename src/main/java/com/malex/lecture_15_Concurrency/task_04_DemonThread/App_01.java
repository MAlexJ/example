package com.malex.lecture_15_Concurrency.task_04_DemonThread;

public class App_01 {

    public static void main(String[] args) throws InterruptedException {

        // Use an empty constructor
        Thread thread = new Thread();
        // To start a thread
        thread.start();

        //Create a new thread
        Thread thread1 = new Thread(new Runnable() {
            // Override the method "run()"
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(Thread.currentThread().getId());
                        System.out.println("This thread works");
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //To start a thread
        thread1.start();

        // Sleep the tread -> "main"
        Thread.sleep(100);
        System.out.println("************* The end thread - main ******************");

    }
}
