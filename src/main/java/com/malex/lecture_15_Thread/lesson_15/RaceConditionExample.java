package com.malex.lecture_15_Thread.lesson_15;

import java.util.stream.IntStream;

/**
 * Tutorial - <a href="https://www.youtube.com/watch?v=c-drxhiXT0Q&list=PLqnlz-HutZiRA06Y-LdunLtHN7XwBZgNG">Lesson 15. RaceCondition</a>
 */
public class RaceConditionExample {

    private static int counter;

    private static final int INCREMENT_AMOUNT_FIRST_THREAD = 500;
    private static final int INCREMENT_AMOUNT_SECOND_THREAD = 500;

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = createThread(INCREMENT_AMOUNT_FIRST_THREAD);
        Thread secondThread = createThread(INCREMENT_AMOUNT_SECOND_THREAD);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(counter);
    }

    private static Thread createThread(int increment) {
        return new Thread(() -> {
            IntStream.range(0, increment).forEach(i -> counter++);
        });
    }
}
