package com.malex.lecture_15_Thread.example_13_singlElementBuffer;

public class App {

    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        int initialValue = 1;
        long productionTime = 5000; // millis

        new Thread(new Producer(buffer, initialValue, productionTime)).start();
        new Thread(new Producer(buffer, initialValue * 100, productionTime - 1000)).start();
        new Thread(new Consumer(buffer)).start();
    }
}