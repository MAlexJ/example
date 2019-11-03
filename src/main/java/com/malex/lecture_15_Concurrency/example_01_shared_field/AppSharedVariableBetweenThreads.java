package com.malex.lecture_15_Concurrency.example_01_shared_field;

import lombok.extern.log4j.Log4j;

import static com.malex.lecture_15_Concurrency.example_01_shared_field.AppConcurrencyUtils.*;

@Log4j
public class AppSharedVariableBetweenThreads {

    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
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
                counter++;
            }
        };
    }
}
