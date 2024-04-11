package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 * <br>
 */
public class OptionalIsPresent extends AbstractUtils {

  @Test
  public void optionalNotEmptyTest() {
    // given
    Optional<String> textOpt = getText("123_adc");

    // then
    assertTrue(textOpt.isPresent());

    // and
    println("result:", textOpt);
  }

  @Test
  public void optionalEmptyTest() {
    // given
    Optional<String> textOpt = getText(null);

    // then
    assertFalse(textOpt.isPresent());

    // and
    println("result:", textOpt);
  }

  private Optional<String> getText(String text) {
    return Optional.ofNullable(text);
  }
}
