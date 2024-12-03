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
 * <p>If a value is present, performs the given action with the value, otherwise does nothing.
 *
 * <p>void ifPresent (Consumer<? super T> action)
 */
public class Optional_ifPresent extends AbstractUtils {

  @Test
  public void ifPresentTest() {
    // given
    var count = new AtomicInteger();

    // when
    Optional.of("Text")
        .ifPresent(
            text ->
                println("result:", text.toUpperCase(), ", increment:", count.incrementAndGet()));

    // then
    assertEquals(1, count.get());
  }

  @Test
  public void ifPresentWithNullValueTest() {
    // given
    var count = new AtomicInteger();

    // when
    Optional.ofNullable(null)
        .map(Object::toString)
        .ifPresent(
            text ->
                println("result:", text.toUpperCase(), ", increment:", count.incrementAndGet()));

    // then
    assertEquals(0, count.get());
  }
}
