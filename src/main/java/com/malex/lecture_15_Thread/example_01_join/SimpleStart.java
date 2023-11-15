package com.malex.lecture_15_Thread.example_01_join;

import static com.malex.lecture_15_Thread.example_01_join.Utils.doSomething;
import static com.malex.lecture_15_Thread.example_01_join.Utils.printToConsole;

/**
 * Created by Alex on 21.02.2015.
 */
public class SimpleStart {

    public static void main(String[] args) throws InterruptedException {

        // #1 create new thread
        Thread thread_1 = new Thread(() -> doSomething("Hello -> ", 5, 2));

        // #2 start thread
        thread_1.start();

        // #3 do something in main thread
        doSomething("Bye -> ", 3, 1);

        // #4 print to console
        printToConsole("That's ALL -> in '", Thread.currentThread().getName(), "' thread");
    }
}
