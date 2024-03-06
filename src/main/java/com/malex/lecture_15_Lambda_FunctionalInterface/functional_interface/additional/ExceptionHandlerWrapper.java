package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.additional;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class ExceptionHandlerWrapper extends AbstractUtils {

  @Test
  public void runSample() {
    exceptionHandler(
        () -> {
          println("consumer 1");

          exceptionHandler(
              () -> {
                println("consumer 2");

                exceptionHandler(
                    () -> {
                      println("consumer 3");
                      throw new RuntimeException();
                    },
                    "Error msg 3");
              },
              "Error msg 2");
        },
        "Error msg 1");
  }

  private void exceptionHandler(Runnable r, String errMsg) {
    try {
      r.run();
    } catch (Exception ex) {
      // close tx or something else
      printError(">>> ", errMsg);
      printlnError(ex, 1);
    }
  }
}
