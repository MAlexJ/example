package com.malex.lecture_15_Threads_and_Executor.example_01_simple;


import lombok.extern.java.Log;

@Log
public class TE_Main_01 {

    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            log.info("Hello " + threadName);
        };

        // #1
        task.run();

        // #2
        new Thread(task).start();

        // #3
        log.info("Done!");
    }
}
