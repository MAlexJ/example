package com.malex.utils;

import static junit.framework.TestCase.fail;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class AbstractUtils {

  public static final String EMPTY_STRING = " ";

  protected void errorHandling(Runnable r) {
    try {
      r.run();
    } catch (Exception e) {
      throw new SampleException(e);
    }
  }

  protected void wrapper(String description, Runnable r) {
    println(description);
    r.run();
    println();
  }

  protected void println(String... str) {
    printlnString(String.join(EMPTY_STRING, str));
  }

  protected void println(Object... args) {
    String logs =
        Arrays.stream(args)
            .filter(Objects::nonNull)
            .map(Object::toString)
            .collect(Collectors.joining(EMPTY_STRING));
    printlnString(logs);
  }

  protected void print(Object... args) {
    String logs =
        Arrays.stream(args)
            .filter(Objects::nonNull)
            .map(Object::toString)
            .collect(Collectors.joining(EMPTY_STRING));
    printString(logs);
  }

  protected void printlnError(Exception ex, int depth) {
    printError("error:", ex.toString());
    printError("error message:", ex.getMessage(), "\n");

    printError("StackTrace:");
    StackTraceElement[] stackTrace = ex.getStackTrace();
    for (int i = 0; i < depth; i++) {
      System.err.println(stackTrace[i]);
    }
  }

  public void printError(String... args) {
    System.err.println(String.join(EMPTY_STRING, args));
  }

  public static void printlnString(String... args) {
    System.out.println(String.join(EMPTY_STRING, args));
  }

  protected static void printString(String msg) {
    System.out.print(msg);
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

  protected void startAllThread(Thread... threads) {
    Arrays.stream(threads).forEach(Thread::start);
  }

  protected void shutdownThread(int millis) {
    new Thread(
            () -> {
              sleepInMillis(millis);
              System.exit(-1);
            })
        .start();
  }

  protected void joinAllThreadToMain(Thread... threads) {
    Arrays.stream(threads)
        .forEach(
            thread -> {
              ;
              try {
                thread.join();
              } catch (InterruptedException e) {
                fail();
              }
            });
  }
}
