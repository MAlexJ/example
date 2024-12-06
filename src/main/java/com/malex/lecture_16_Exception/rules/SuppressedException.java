package com.malex.lecture_16_Exception.rules;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import java.util.Arrays;
import org.junit.Test;

public class SuppressedException extends AbstractUtils {

  @Test
  public void testExResource() {
    try (ExResource ex0 = new ExResource(0);
        ExResource ex1 = new ExResource(1);
        ExResource ex2 = new ExResource(2);
        ExResource ex3 = new ExResource(3)) {

      ex0.calc(20, 2);
      ex1.calc(12, 2);
      ex2.calc(6, 2);

      /* java.lang.ArithmeticException: / by zero */
      ex3.calc(3, 0);

    } catch (Exception e) {
      println("Last exception in application:", e.toString());

      // suppressed exception
      Throwable[] suppressed = e.getSuppressed();
      println("Suppressed exception:");
      Arrays.stream(suppressed).forEach(ex -> println(" -", ex.toString()));
    }
  }

  private record ExResource(Integer operationNumber) implements AutoCloseable {

    void calc(int a, int b) {
      int result = a / b;
      printlnString(
          "Number: %s".formatted(operationNumber),
          ", calculation: a / b = ",
          Integer.toString(result));
    }

    @Override
    public void close() {
      /*
       * Simulate exception case when closing resources
       */
      throw new SampleException("Close resources, after operation: %s".formatted(operationNumber));
    }
  }
}
