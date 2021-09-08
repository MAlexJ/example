package com.malex.lecture_16_Exception.example_03_syntax;

public class App_01 {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        runnable.run();
    }
}

class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("run()");
    }
}
