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
public class OptionalOrElse extends AbstractUtils {

  @Test
  public void orElseTest() {
    // given
    String name = null;

    // when
    var nameOpt = Optional.ofNullable(name).orElse("name");

    // then
    assertEquals("name", nameOpt);
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
