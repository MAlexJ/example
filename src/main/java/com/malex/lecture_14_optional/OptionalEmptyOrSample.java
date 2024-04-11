package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * Documentation 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 * <br>
 */
public class OptionalEmptyOrSample extends AbstractUtils {

  @Test
  public void testEmptyOr() {
    // given
    var number = Integer.valueOf(983);

    // when
    var resultNumber =
        Optional.empty()
            .or(() -> Optional.empty())
            .or(() -> Optional.ofNullable(null))
            .or(() -> Optional.of(number))
            .filter(isInteger())
            .map(Integer.class::cast)
            .orElseThrow();

    // then
    assertEquals(number, resultNumber);
  }

  private Predicate<Object> isInteger() {
    return number -> {
      print("number:", number);
      return number instanceof Integer;
    };
  }
}
