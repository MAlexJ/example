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
 * <p>Optional<T> filter(Predicate<T> predicate )
 *
 * <p>If a value is present, and the value matches the given predicate, returns an Optional
 * describing the value, otherwise returns an empty Optional.
 *
 * <p>@Contract("null->!null") <br>
 * public Optional<T> filter( @NotNull Predicate<? super T> predicate )
 */
public class Optional_filter extends AbstractUtils {

  public static final String EMPTY_VALUE = "empty!";

  @Test
  public void optional_filter_test() {
    // given
    Predicate<String> condition = str -> str.contains("t");

    // when
    var test =
        getText("test")
            /*  Optional<T> filter( Predicate<T> predicate ) */
            .filter(condition)
            .orElse(EMPTY_VALUE);

    // then
    assertEquals("test", test);
  }

  @Test
  public void optional_many_filters_test() {
    // given
    var test =
        getText("test")
            .filter(str -> str.contains("t"))
            .filter(str -> str.contains("e"))
            .filter(str -> str.contains("s"))
            .orElse(EMPTY_VALUE);

    // then
    assertEquals("test", test);
  }

  @Test
  public void optional_not_pass_by_filter_criteria_test() {
    // given
    var defaultValue = EMPTY_VALUE;

    // when
    var firstVal =
        getText("") //
            .filter(str -> str.contains("t"))
            .orElse(defaultValue);

    // and
    var secondVal =
        getText(null) //
            .filter(str -> str.contains("t"))
            .orElse(defaultValue);

    // then
    assertEquals(defaultValue, firstVal);
    assertEquals(defaultValue, secondVal);
  }

  private Optional<String> getText(String text) {
    return Optional.ofNullable(text);
  }
}
