package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Documentation <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 *
 * <p>If a value is present, performs the given action with the value, otherwise performs the given
 * empty-based action.
 *
 * <p>public void ifPresentOrElse( Consumer<? super T> action, Runnable emptyAction )
 */
public class Optional_ifPresentOrElse extends AbstractUtils {

  @Test
  public void ifPresentOrElse_not_empty_value_test() {
    // given
    var count = new AtomicInteger();

    // when
    getText("test")
        .ifPresentOrElse(
            t -> {
              int increment = count.incrementAndGet();
              println("Value present:", t, "increment:", increment);
            },
            () -> {
              count.incrementAndGet();
              int increment = count.incrementAndGet();
              println("Default", "increment:", increment);
            });

    // then
    assertEquals(1, count.get());
  }

  @Test
  public void ifPresentOrElse_null_value_test() {
    // given
    var count = new AtomicInteger();

    // when
    getText(null)
        .ifPresentOrElse(
            t -> {
              int increment = count.incrementAndGet();
              println("Value present:", t, "increment:", increment);
            },
            () -> {
              int increment = count.incrementAndGet();
              println("Default", ", increment:", increment);
            });

    // then
    assertEquals(1, count.get());
  }

  private Optional<String> getText(String text) {
    return Optional.ofNullable(text);
  }
}
