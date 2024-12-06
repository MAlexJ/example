package com.malex.lecture_16_Exception.super_vs_ovverride_getMessage;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class SupperVsOverrideMethod extends AbstractUtils {

  @Test
  public void testExceptionSuperMethod() {
    // given
    String message = "This is a test message";
    try {

      // when
      throw new MyExceptionSuperMethod(message);
    } catch (MyExceptionSuperMethod e) {

      // then
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void testOverrideGetMethod() {
    // given
    String message = "This is a test message";
    try {

      // when
      throw new MyExceptionOverrideGetMethod(message);
    } catch (MyExceptionOverrideGetMethod e) {

      // then
      assertEquals(message, e.getMessage());
    }
  }

  static class MyExceptionSuperMethod extends Exception {

    MyExceptionSuperMethod(String message) {
      /*
      * MyExceptionSuperMethod(String message) {....}
      *     |
      * public Exception(String message) {super(message); }
      *     |
      * public Throwable(String message) {
             fillInStackTrace();
             detailMessage = message;
             if (jfrTracing) {
               ThrowableTracer.traceThrowable(getClass(), message);
             }
        }
       */
      super(message);
    }
  }

  static class MyExceptionOverrideGetMethod extends Exception {
    private final String errorMessage;

    MyExceptionOverrideGetMethod(String errorMessage) {
      this.errorMessage = errorMessage;
    }

    /*
     * Throwable FIELD:
     * Specific details about the Throwable.  For example, for
     * {@code FileNotFoundException}, this contains the name of
     * the file that could not be found.
     *

     private String detailMessage;

    * Throwable METHOD:
    * Returns the detail message string of this throwable.
    *
    * @return  the detail message string of this {@code Throwable} instance (which may be {@code null}).
      public String getMessage() {
         return detailMessage;
      }
    */
    @Override
    public String getMessage() {
      return errorMessage;
    }
  }
}
