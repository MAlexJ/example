package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * Documentation: <br>
 * 1. <a href="https://habr.com/ru/articles/658457/">Java Class guide Optional</a>
 *
 * <p>If a value is present, returns the value, otherwise returns the result produced by the
 * supplying function.
 *
 * <p>public T orElseGet( Supplier <? extends T> supplier )
 */
public class OptionalOrElseGet extends AbstractUtils {

  @Test
  public void orElseGetTest() {
    // given
    var str =
        Optional.ofNullable(null)
            .map(Object::toString)
            .orElseGet(
                new Supplier<String>() {
                  @Override
                  public String get() {
                    return "Supplier";
                  }
                });

    // then
    assertEquals("Supplier", str);
  }

  @Test(expected = NullPointerException.class)
  public void orElseGetNullValueTest() {
    // given
    Optional.ofNullable(null).map(Object::toString).orElseGet(null);
  }

  @Test
  public void orElseGetNullInsideSupplierTest() {
    // given
    var str =
        Optional.ofNullable(null)
            .map(Object::toString)
            .orElseGet(
                new Supplier<String>() {
                  @Override
                  public String get() {
                    return null;
                  }
                });
    println("Supplier value is", str);
    assertNull(str);
  }
}
