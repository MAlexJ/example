package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation: <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 *
 * <p>If a value is present, returns the value, otherwise returns other <br>
 *
 * <p>@Contract(value = "!null -> !null", pure = true) <br>
 * public T orElse( @Nullable T other )
 */
public class Optional_orElse extends AbstractUtils {

  @Test
  public void orElse_test() {
    // given
    String name = null;

    // when
    var nameOpt = Optional.ofNullable(name).orElse("name");

    // then
    assertEquals("name", nameOpt);
  }

  @Test
  public void orElse_eager_test() {
    // given
    String name = "Test";

    // when
    var nameOpt =
        Optional.ofNullable(name)
            .map(
                v -> {
                  println("1. Optional.map(...)");
                  return v;
                })
            .orElse(getString());

    // then
    assertEquals("Test", nameOpt);
  }

  private String getString() {
    println("2. Optional.orElse(...) id eager!!!");
    return "name";
  }

  /** Return null */
  @Test
  public void orElsePassNull() {
    // given
    var str = Optional.ofNullable(null).map(Object::toString).orElse(null);

    // then
    assertNull(str);
  }
}
