package com.malex.lecture_15_Concurrency.lecture_01_exeption_syntax.task_02;

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
