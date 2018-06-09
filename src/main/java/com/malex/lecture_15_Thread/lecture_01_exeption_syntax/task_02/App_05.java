package com.malex.lecture_15_Thread.lecture_01_exeption_syntax.task_02;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_05 {

    public static void main(String[] args) {
        Thread me = Thread.currentThread();
        System.out.println("main() " + me.getName());

        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run() " + Thread.currentThread().getName());
            }
        });

        newThread.start();

    }
}
