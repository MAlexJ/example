package com.malex.lecture_15_concurrency;

import static junit.framework.TestCase.fail;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AbstractThreadUtils {

  protected static void print(String... logs) {
    System.out.println(String.join(" ", logs));
  }

  protected static void print(Object... logs) {
    String collect =
        Arrays.stream(logs)
            .map(
                l -> {
                  if (l instanceof Number) {
                    return l.toString();
                  }
                  if (l instanceof String) {
                    return (String) l;
                  }
                  if (l.getClass().isArray()) {
                    Class<?> elementType = l.getClass().getComponentType();
                    if (elementType.getName().equals("int")) {
                      int[] array = (int[]) l;
                      array = array.length > 10 ? Arrays.copyOfRange(array, 0, 9) : array;
                      return Arrays.toString(array) + " ..... n ]";
                    }
                    throw new UnsupportedOperationException();
                  }
                  return l.toString();
                })
            .collect(Collectors.joining(" "));
    System.out.println(collect);
  }

  protected static void printError(String... logs) {
    System.err.println(String.join(" ", logs));
  }

  protected static void javaStatistic() {
    int processors = Runtime.getRuntime().availableProcessors();
    print("Number of processors available to the Java virtual machine - ", processors);

    long totalMemory = Runtime.getRuntime().totalMemory();
    print(
        "Total amount of memory in Java virtual machine in bytes:",
        totalMemory,
        ", or",
        convertToMbs(totalMemory),
        "Mbs");

    long freeMemory = Runtime.getRuntime().freeMemory();
    print(
        "Amount of free memory in Java Virtual Machine in bytes:",
        freeMemory,
        ", or",
        convertToMbs(freeMemory),
        "Mbs");

    long maxMemory = Runtime.getRuntime().maxMemory();
    print(
        "Maximum amount of memory that Java virtual machine will attempt to use in bytes:",
        maxMemory,
        ", or",
        convertToMbs(maxMemory),
        "Mbs");
  }

  private static Float convertToMbs(long bytes) {
    return (float) bytes / 1000000;
  }

  protected static String getCurrentThreadName() {
    return Thread.currentThread().getName();
  }

  protected static void sleepIgnoreException(long millis) {
    try {
      TimeUnit.MILLISECONDS.sleep(millis);
    } catch (InterruptedException e) {
      String threadName = getCurrentThreadName();
      print(threadName, " was interrupted!");
      throw new RuntimeException(e);
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

  protected void sleepInMillis(int millis) {
    try {
      TimeUnit.MILLISECONDS.sleep(millis);
    } catch (InterruptedException e) {
      e.fillInStackTrace();
    }
  }
}
