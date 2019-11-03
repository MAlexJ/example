package com.malex.lecture_15_Concurrency.example_01_shared_field;

import lombok.extern.log4j.Log4j;

@Log4j
public class AppConcurrencyUtils {

    public static final int N = 10_000_000;
    public static final String INFO_MSG = "Counter result: %s";

    /**
     * Log thread
     */
    public static void logThread() {
        log.info(Thread.currentThread().getName());
    }

    /**
     * Create a new Thread
     */
    public static Thread createNewThread(Runnable run) {
        return new Thread(run);
    }
}
