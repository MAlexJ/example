package com.malex.lecture_16_Exception.example_03_syntax;

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
