package com.malex.lecture_14_optional;

import static junit.framework.TestCase.*;

import com.malex.utils.AbstractUtils;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Test;

/**
 * Documentation <br>
 * 1.Optional tutorial: <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 *
 * <p>Returns an empty Optional instance. No value is present for this Optional.
 *
 * <p>@Contract(pure = true) <br>
 * public static <T> Optional<T> empty()
 */
public class OptionalEmpty extends AbstractUtils {

  @Test
  public void emptyOptional() {
    Optional<Object> empty = Optional.empty();

    assertTrue(empty.isEmpty());

    assertFalse(empty.isPresent());

    try {
      empty.get(); // NoSuchElementException
      fail();
    } catch (NoSuchElementException ex) {
      // none
      printlnError(ex, 2);
    }
  }
}
