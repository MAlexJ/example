package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

import com.malex.utils.AbstractUtils;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 * <br>
 */
public class Optional_flatMap extends AbstractUtils {

  @Test
  public void flatmapTest() {
    // given
    var test =
        getText("te")
            .flatMap(str -> getText(str + "s"))
            .flatMap(str -> getText(str + "t"))
            .orElseThrow();

    // then
    assertEquals("test", test);
    println("result:", test);
  }

  @Test(expected = NoSuchElementException.class)
  public void flatmapOneNullTest() {
    // given
    getText("te")
        .flatMap(str -> getText("s"))
        .flatMap(str -> getText("t"))
        .flatMap(str -> getText(null))
        .flatMap(str -> getText("+"))
        .orElseThrow(); // throw -> NoSuchElementException

    // then
    fail();
  }

  private Optional<String> getText(String text) {
    print(text);
    return Optional.ofNullable(text);
  }
}
