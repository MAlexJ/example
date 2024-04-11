package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.Optional;
import org.junit.Test;

/**
 * Documentation <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a> <br>
 */
public class OptionalFilterAsConditionSample {

  @Test
  public void conditionalTest() {
    assertTrue(isNotNullAndLesThatNumber(1, 5));
    assertTrue(isNotNullAndLesThatNumber(4, 5));

    assertFalse(isNotNullAndLesThatNumber(null, 1));
    assertFalse(isNotNullAndLesThatNumber(null, null));
  }

  private boolean isNotNullAndLesThatNumber(Integer num, Integer lesThatNum) {
    return Optional.ofNullable(num) //
        .filter(val -> val < lesThatNum)
        .isPresent();
  }
}
