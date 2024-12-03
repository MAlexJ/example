package com.malex.lecture_14_optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation: <br>
 * 1. Tutorial <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 */
public class Optional_orElseThrow {

  @Test(expected = IllegalArgumentException.class)
  public void orElseThrowTest() {
    Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
  }

  @Test(expected = ArithmeticException.class)
  public void orElseThrowWithMessageTest() {
    Optional.ofNullable(null).orElseThrow(() -> new ArithmeticException("Error message"));
  }

  @Test(expected = NoSuchElementException.class)
  public void orElseThrowDefaultTest() {
    Optional.ofNullable(null).orElseThrow();
  }
}
