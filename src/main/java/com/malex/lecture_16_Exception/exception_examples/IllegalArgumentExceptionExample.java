package com.malex.lecture_16_Exception.exception_examples;

import org.junit.Test;

public class IllegalArgumentExceptionExample {

  @Test(expected = IllegalArgumentException.class)
  public void test() throws InterruptedException {
    // given
    long negativeNumber = -1l;

    /*
     * Throws: IllegalArgumentException – if timeoutMillis is negative
     */
    new Object().wait(negativeNumber);
  }
}
