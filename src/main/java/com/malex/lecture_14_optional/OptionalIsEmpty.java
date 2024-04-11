package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertTrue;

import java.util.Optional;
import org.junit.Test;

/**
 * Documentation <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 *
 * <p>If a value is not present, returns true, otherwise false.
 */
public class OptionalIsEmpty {

  @Test
  public void test() {
    // given
    Optional<Object> optional = Optional.ofNullable(null);

    // ten
    assertTrue(optional.isEmpty());
  }
}
