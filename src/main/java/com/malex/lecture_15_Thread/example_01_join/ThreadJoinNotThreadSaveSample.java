package com.malex.lecture_15_Thread.example_01_join;

import lombok.extern.java.Log;

@Log
public class ThreadJoinNotThreadSaveSample {

    private static final int N = 1_000_000_000;

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });

        log.info("Start first thread - " + firstThread.getName());
        firstThread.start();

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });

        log.info("Start second thread - " + secondThread.getName());
        secondThread.start();

        log.info("First thread join");
        firstThread.join(1000L);

        log.info("Second thread join");
        secondThread.join();

        log.info("Result of calculation - " + counter);
    }
}
