package com.malex.lecture_16_Exception.example_03_syntax;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_02 {

    public static void main(String[] args) {

        Runnable r0 = new RunnableImpl();
        Runnable r1 = new RunnableImpl();

        r0.run();
        r1.run();
    }
}
