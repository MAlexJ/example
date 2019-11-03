package com.malex.lecture_15_Concurrency.example_02_join;

import lombok.extern.log4j.Log4j;

@Log4j
public class AppRunThreadWithJoin {

    public static void main(String[] args) throws InterruptedException {

        // #1 run a new thread
        Thread thread_1 = new Thread(someUsefulWork());
        thread_1.start();

        // #2 the main thread
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            log.info("Bye -> " + Thread.currentThread().getName());
        }

        // #3 join the new thread to main thread : Waits for this thread to die.
        thread_1.join();

        // #4 the end of main thread
        log.info("That's ALL -> " + Thread.currentThread().getName());
    }

    private static Runnable someUsefulWork() {
        return () -> {
            try {
                for (int i = 0; i < 6; i++) {
                    Thread.sleep(1000);
                    log.info("Hello -> " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
