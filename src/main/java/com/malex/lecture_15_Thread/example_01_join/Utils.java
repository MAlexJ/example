package com.malex.lecture_15_Thread.example_01_join;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Utils {

    private Utils() {
        // none use
    }


    @SneakyThrows
    public static void doSomething(String message, int count, int waitInSeconds) {
        for (int i = 0; i < count; i++) {
            TimeUnit.SECONDS.sleep(waitInSeconds);
            printToConsole(message, Thread.currentThread().getName());
        }
    }

    public static void printToConsole(String... args) {
        Arrays.asList(args).forEach(System.out::print);
        System.out.println();
    }
}
