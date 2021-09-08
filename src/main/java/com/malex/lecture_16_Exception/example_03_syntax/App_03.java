package com.malex.lecture_16_Exception.example_03_syntax;

public class App_03 {

    public static void main(String[] args) {
        //anonymous class
        // If I use one time.
        //See -> App_03.class
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run()");
            }
        };
        r.run();

        System.out.println(r.getClass().getName());

    }
}
