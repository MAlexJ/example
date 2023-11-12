package com.malex.lecture_15_Thread.lesson_16;

import java.util.stream.IntStream;

/**
 * Tutorial - <a href="https://www.youtube.com/watch?v=7df1AI93o1E">Lesson 17. Synchronized</a>
 */
public class SynchronizedExample {

    private final static int INCREMENT_AMOUNT_FIRST_THREAD = 500;
    private final static int INCREMENT_AMOUNT_SECOND_THREAD = 600;

    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = createIncrementingCounterThread(INCREMENT_AMOUNT_SECOND_THREAD);
        Thread secondThread = createIncrementingCounterThread(INCREMENT_AMOUNT_FIRST_THREAD);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(counter);
    }

    private static Thread createIncrementingCounterThread(int increment) {
        return new Thread(() -> IntStream.range(0, increment).forEach(i -> incrementCounter()));
    }

    private static synchronized void incrementCounter() {
         counter++;
    }
}
