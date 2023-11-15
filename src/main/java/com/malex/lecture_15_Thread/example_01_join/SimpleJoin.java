package com.malex.lecture_15_Thread.example_01_join;

import static com.malex.lecture_15_Thread.example_01_join.Utils.doSomething;
import static com.malex.lecture_15_Thread.example_01_join.Utils.printToConsole;

/**
 * Created by Alex on 21.02.2015.
 */
public class SimpleJoin {

    public static void main(String[] args) throws InterruptedException {

        // #1 create new thread
        Thread thread = new Thread(() -> doSomething("-> Hello from thread : ", 5, 2));

        // #2 start thread
        thread.start();

        // #3 do something in main thread
        doSomething("  -> Bye from thread : ", 3, 1);

        // #4 join thread-0 to main
        thread.join();

        // #5 end main thread
        printToConsole("That's ALL -> in '", Thread.currentThread().getName(), "' thread");
    }

}
