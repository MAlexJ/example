package com.malex.lecture_15_concurrency.example_09_interrupt_thread;

import java.util.concurrent.TimeUnit;

public class InterruptStopSample {

    private static boolean isContinueProcessing = true;

    public static void main(String[] args) {
        // #1 create first service
        Thread firstService = new Thread(() -> {
            while (isContinueProcessing) {
                print(">>> Start process in thread - ", Thread.currentThread().getName(), " is interrupted - ");
                sleep(1);
                print("<<< End process in thread - ", Thread.currentThread().getName());
            }
        });

        // #2 create second service
        Thread secondService = new Thread(() -> {
            sleep(1);
            print(" ~ Handle process by thread - ", Thread.currentThread().getName());
            sleep(3);

            stopThread(firstService);
        });

        // #3 start all services
        firstService.start();
        secondService.start();
    }

    /**
     * stop() method is deprecated  from since="1.2",
     * throws: UnsupportedOperationException
     */
    private static void stopThread(Thread firstService) {
        try {
            firstService.stop();
        } catch (Exception e) {
            changeStatus();
            throw e;
        }
    }

    private static void changeStatus() {
        isContinueProcessing = false;
    }


    private static void sleep(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            String threadName = Thread.currentThread().getName();
            print(threadName, " was interrupted!");
        }
    }

    private static void print(String... logs) {
        System.out.println(String.join(" ", logs));
    }

}