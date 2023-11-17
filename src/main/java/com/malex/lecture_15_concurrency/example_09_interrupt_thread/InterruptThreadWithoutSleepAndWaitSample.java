package com.malex.lecture_15_concurrency.example_09_interrupt_thread;

import com.malex.lecture_15_concurrency.AbstractThreadSample;

public class InterruptThreadWithoutSleepAndWaitSample extends AbstractThreadSample {

    public static void main(String[] args) {
        // #0 start main thread
        print("Start main thread - ", getCurrentThreadName());

        // #1 create first service
        Thread firstService = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                print(">>> Start process in thread - ", getCurrentThreadName());
                print("<<< End process in thread - ", getCurrentThreadName());
            }
            print("!!! ", Thread.currentThread().getName(), " interrupted", "!!!");
        });

        // #2 create second service
        Thread secondService = new Thread(() -> {
            print(" ~ Handle process by thread - ", getCurrentThreadName());
            attemptInterruptThread(firstService);
        });

        // #3 start first thread
        firstService.start();

        // #4 sleep 200 millis
        sleepIgnoreException(200);

        // #5 start second thread
        secondService.start();
    }

    /**
     * stop() method is deprecated  from since="1.2",
     * throws: UnsupportedOperationException
     * <p>
     * Interrupts this thread.
     * Unless the current thread is interrupting itself, which is always permitted,
     * the checkAccess method of this thread is invoked, which may cause a SecurityException to be thrown
     */
    private static void attemptInterruptThread(Thread firstService) {
        try {
            firstService.interrupt();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}