package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * Documentation <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 *
 * <p>If a value is present, and the value matches the given predicate, returns an Optional
 * describing the value, otherwise returns an empty Optional.
 *
 * <p>@Contract("null->!null") <br>
 * public Optional<T> filter( @NotNull Predicate<? super T> predicate )
 */
public class OptionalFilter extends AbstractUtils {

  @Test
  public void optionalFilterTest() {
    // given
    Predicate<String> condition = str -> str.contains("t");

    // when
    var test = getText("test").filter(condition).orElse("empty!");

    // then
    assertEquals("test", test);
  }

  @Test
  public void optionalManyFilterTest() {
    // given
    var test =
        getText("test")
            .filter(str -> str.contains("t"))
            .filter(str -> str.contains("e"))
            .filter(str -> str.contains("s"))
            .orElse("empty!");

    // then
    assertEquals("test", test);
  }

  @Test
  public void optionalNotPassFilterTest() {
    // given
    var defaultValue = "empty!";

    // when
    var test = getText("").filter(str -> str.contains("t")).orElse(defaultValue);
    var test2 = getText(null).filter(str -> str.contains("t")).orElse(defaultValue);

    // then
    assertEquals(defaultValue, test);
    assertEquals(defaultValue, test2);
  }

  private Optional<String> getText(String text) {
    return Optional.ofNullable(text);
  }
}
