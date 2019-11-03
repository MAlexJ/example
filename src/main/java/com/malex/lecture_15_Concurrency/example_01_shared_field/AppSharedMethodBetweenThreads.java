package com.malex.lecture_15_Concurrency.example_01_shared_field;

import lombok.extern.log4j.Log4j;

import static com.malex.lecture_15_Concurrency.example_01_shared_field.AppConcurrencyUtils.*;

@Log4j
public class AppSharedMethodBetweenThreads {

    private static int counter = 0;

    private static void inc() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        logThread();

        Thread thread_0 = createNewThread(someUsefulWork());
        thread_0.start();

        Thread thread_1 = createNewThread(someUsefulWork());
        thread_1.start();

        thread_0.join();
        thread_1.join();

        log.info(String.format(INFO_MSG, counter));
    }

    private static Runnable someUsefulWork() {
        return () -> {
            logThread();
            for (int i = 0; i < N; i++) {
                inc();
            }
        };
    }
}
