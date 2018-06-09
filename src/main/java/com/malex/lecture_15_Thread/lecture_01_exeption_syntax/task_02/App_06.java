package com.malex.lecture_15_Thread.lecture_01_exeption_syntax.task_02;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_06 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            sillyWork();
            System.out.println("sillyWork()");
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
