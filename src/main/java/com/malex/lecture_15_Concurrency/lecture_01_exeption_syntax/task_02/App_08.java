package com.malex.lecture_15_Concurrency.lecture_01_exeption_syntax.task_02;

public class App_08 {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    sillyWork();
                    //System.out.print(Thread.currentThread().getName());
                    System.out.println("Hello");
                }
            }
        }).start();
        for (int i = 0; i < 5; i++) {
            sillyWork();
            //System.out.print(Thread.currentThread().getName());
            System.out.println("Bye");
        }

    }

    //Load CPU <= 100%
    private static void sillyWork() {
        double d = 2.0;
        for (int i = 0; i < 10_000_000; i++) {
            d = Math.sin(d);
        }
    }
}
