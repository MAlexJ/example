package com.malex.lecture_15_Thread.example_01_join;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;

public class Utils extends AbstractUtils {

  private Utils() {
    // none use
  }

  public static void doSomething(String message, int count, int waitInSeconds) {
    for (int i = 0; i < count; i++) {
      sleepInSecondStatic(waitInSeconds);
      printToConsole(message, Thread.currentThread().getName());
    }
  }

  public static void printToConsole(String... args) {
    Arrays.asList(args).forEach(AbstractUtils::printString);
    printlnString();
  }
}
