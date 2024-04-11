package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Documentation <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 */
public class OptionalStream extends AbstractUtils {

  @Test
  public void chainOfOptionalTest() {
    // given
    Stream<Optional<String>> optionalStream =
        Stream.of(
            Optional.empty(), //
            Optional.of("x"), //
            Optional.ofNullable(null));

    // when
    Optional<String> first =
        optionalStream.filter(Optional::isPresent).map(Optional::get).findFirst();

    // then
    println(first);
    assertTrue(first.isPresent());
  }
}
