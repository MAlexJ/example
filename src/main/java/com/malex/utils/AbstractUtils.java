package com.malex.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class AbstractUtils {

    protected void wrapper(String description, Runnable r) {
        println(description);
        r.run();
        println();
    }

    protected void println(String... str) {
        System.out.println(String.join(" ", str));
    }

    protected void println(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(logs);
    }

    protected void print(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.print(logs);
    }

    protected String getHashcode(Number i) {
        return Integer.toHexString(System.identityHashCode(i));
    }

    protected void sleepInMillis(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }

    protected void randomSleepInMillis(int millis) {
        try {
            int random = new Random().nextInt(millis, millis + 1000);
            println("... sleep:", random, "ms,", "thread:", Thread.currentThread().getName(), "...");
            TimeUnit.MILLISECONDS.sleep(random);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
