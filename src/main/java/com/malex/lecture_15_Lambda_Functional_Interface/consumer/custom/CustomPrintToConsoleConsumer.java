package com.malex.lecture_15_Lambda_Functional_Interface.consumer.custom;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/** Simple example of using terminal lambda expression */
public class CustomPrintToConsoleConsumer extends AbstractUtils {

  @Test
  public void printSample() {
    PrintConsumer consumer = this::println;
    consumer.print("Hello!");
  }

  /** Functional interface */
  @FunctionalInterface
  private interface PrintConsumer {

    /**
     * Functional interface must contain only a single method with no implementation.
     *
     * @param str the incoming value.
     */
    void print(String str);
  }
}
